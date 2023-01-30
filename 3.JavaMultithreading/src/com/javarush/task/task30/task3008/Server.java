package com.javarush.task.task30.task3008;

import com.javarush.task.task30.task3008.client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()
        ) {
            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.println(" Сообщение не отпралено");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message = null;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST, "Введите имя"));

                message = connection.receive();
                if (message.getType().equals(MessageType.USER_NAME)) {
                    if (message.getData() != null && !message.getData().equals("") && !connectionMap.containsKey(message.getData())) {
                        connectionMap.put(message.getData(), connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED, "Имя принято"));
                        break;
                    }
                }
            }
            return message.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()
            ) {
                if (!name.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true){
                Message mm = connection.receive();
                if ( mm.getType() == MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + mm.getData()));

                }
                else {
                    ConsoleHelper.writeMessage("Это не текст");
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("установлено новое соединение с удаленным адресом" + socket.getRemoteSocketAddress());
            String newUser = null;
            try  (   Connection connection = new Connection(socket)){

                newUser = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUser));
                notifyUsers(connection, newUser);
                serverMainLoop(connection, newUser);
            }
            catch (IOException | ClassNotFoundException e){
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");
            }
            if (newUser != null) {
                connectionMap.remove(newUser);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUser));
            }
            ConsoleHelper.writeMessage("соединение с удаленным адресом закрыто");
            }


    }

    /*

     */
    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {

            System.out.println("Сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();

            }
        } catch (Exception e) {

            System.out.println("Ошибка");
        }

    }

}
/*
4) Метод main класса Server, должен:

а) Запрашивать порт сервера, используя ConsoleHelper.
б) Создавать серверный сокет java.net.ServerSocket, используя порт из предыдущего пункта.
в) Выводить сообщение, что сервер запущен.
г) В бесконечном цикле слушать и принимать входящие сокетные соединения только что созданного серверного сокета.
д) Создавать и запускать новый поток Handler, передавая в конструктор сокет из предыдущего пункта.
е) После создания потока обработчика Handler переходить на новый шаг цикла.
ж) Предусмотреть закрытие серверного сокета в случае возникновения исключения.
з) Если исключение Exception все же произошло, поймать его и вывести сообщение об ошибке.
 */