package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() throws IOException, ClassNotFoundException {
        ConsoleHelper.writeMessage("ВВедите адрес сервера");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("ВВедите номер порта");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("ВВедите Имя пользователя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Сообщение не отпрвлено");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                wait();
            } catch (Exception e) {
                ConsoleHelper.writeMessage(" Во время ожидания возникла ошибка");
                return;
            }
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено.\n" +
                    "Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        while (clientConnected) {
            String message = ConsoleHelper.readString();
            if (message.equals("exit")) {
                break;
            }
            if (shouldSendTextFromConsole()) {
                sendTextMessage(message);
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Пользователь " + userName + " присоеденился к чату");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Пользователь " + userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                try {
                    Client.this.notify();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else if (message.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                } else {

                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                }
               else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                }
               else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                }
               else {
                    throw new IOException("Unexpected MessageType");

                }
            }
        }

        @Override
        public void run() {
            try {
                Socket socket = new Socket(getServerAddress(),getServerPort() );
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);

            }

        }
    }
}
/*
Давай напишем ее:
1) Запроси адрес и порт сервера с помощью методов getServerAddress() и getServerPort().
2) Создай новый объект класса java.net.Socket, используя данные, полученные в предыдущем пункте.
3) Создай объект класса Connection, используя сокет из п.17.2.
4) Вызови метод, реализующий "рукопожатие" клиента с сервером (clientHandshake()).
5) Вызови метод, реализующий основной цикл обработки сообщений сервера.
6) При возникновении исключений IOException или ClassNotFoundException сообщи главному потоку о проблеме, используя notifyConnectionStatusChanged() и
false в качестве параметра.

Клиент готов, можешь запустить сервер, несколько клиентов и проверить как все работает.


Requirements:
1. В методе run() должно быть установлено и сохранено в поле connection соединение с сервером (для получения адреса сервера и порта используй методы getServerAddress() и getServerPort()).
2. В методе run() должен быть вызван метод clientHandshake().
3. В методе run() должен быть вызван метод clientMainLoop().
4. При возникновении исключений IOException или ClassNotFoundException в процессе работы метода run(), должен быть вызван метод notifyConnectionStatusChanged() с параметром false.
5. Заголовок метода run() должен соответствовать условию задачи.
 */