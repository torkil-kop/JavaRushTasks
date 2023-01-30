package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class BotClient extends Client {


    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {

           BotClient.this.sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
                     ConsoleHelper.writeMessage(message);
            String[] strings = message.split(": ");
            if (strings.length !=2){
                return;
            }
            String name = strings[0];
            String text = strings[1];

            Calendar calendar = Calendar.getInstance();


            switch (text) {
                case "дата":
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                    BotClient.this.sendTextMessage("Информация для " + name + ": " + simpleDateFormat.format(calendar.getTime()));
                    break;
                case "день":
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("d");
                    BotClient.this.sendTextMessage("Информация для " + name + ": " + simpleDateFormat2.format(calendar.getTime()));
                    break;
                case "месяц":
                    SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MMMM");
                    BotClient.this.sendTextMessage("Информация для " + name + ": " + simpleDateFormat3.format(calendar.getTime()));
                    break;
                case "год":
                    SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("YYYY");
                    BotClient.this.sendTextMessage("Информация для " + name + ": " + simpleDateFormat4.format(calendar.getTime()));
                    break;
                case "время":
                    SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("H:mm:ss");
                    BotClient.this.sendTextMessage("Информация для " + name + ": " + simpleDateFormat5.format(calendar.getTime()));
                    break;
                case "час":
                    SimpleDateFormat simpleDateFormat6 = new SimpleDateFormat("H");
                    BotClient.this.sendTextMessage("Информация для " + name + ": " + simpleDateFormat6.format(calendar.getTime()));
                    break;
                case "минуты":
                    SimpleDateFormat simpleDateFormat7 = new SimpleDateFormat("m");
                    BotClient.this.sendTextMessage("Информация для " + name + ": " + simpleDateFormat7.format(calendar.getTime()));
                    break;
                case "секунды":
                    SimpleDateFormat simpleDateFormat8 = new SimpleDateFormat("s");
                    BotClient.this.sendTextMessage("Информация для " + name + ": " + simpleDateFormat8.format(calendar.getTime()));
                    break;
            }

        }
    }

    /*
    в) Отправить ответ в зависимости от текста принятого сообщения.
    Если текст сообщения:
    "дата" - отправить сообщение содержащее текущую дату в формате "d.MM.YYYY";
    "день" - в формате "d";
    "месяц" - "MMMM";
    "год" - "YYYY";
    "время" - "H:mm:ss";
    "час" - "H";
    "минуты" - "m";
    "секунды" - "s".
     */
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {

        return "date_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}
/*
1. Переопредели метод clientMainLoop():
а) С помощью метода sendTextMessage() отправь сообщение с текстом "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды."
б) Вызови реализацию clientMainLoop() родительского класса.

2. Переопредели метод processIncomingMessage(String message).
Он должен следующим образом обрабатывать входящие сообщения:
а) Вывести в консоль текст полученного сообщения message.
б) Получить из message имя отправителя и текст сообщения. Они разделены ": ".
в) Отправить ответ в зависимости от текста принятого сообщения.
Если текст сообщения:
"дата" - отправить сообщение содержащее текущую дату в формате "d.MM.YYYY";
"день" - в формате "d";
"месяц" - "MMMM";
"год" - "YYYY";
"время" - "H:mm:ss";
"час" - "H";
"минуты" - "m";
"секунды" - "s".
Указанный выше формат используй для создания объекта SimpleDateFormat. Для получения текущей даты необходимо использовать класс Calendar и метод getTime().
Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ, например, если Боб отправил запрос "время", мы должны отправить ответ "Информация для Боб: 12:30:47".

Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись, что все работает правильно.
Помни, что message бывают разных типов и не всегда содержат ":"


Requirements:
1. Метод clientMainLoop()класса BotSocketThread должен вызывать метод sendTextMessage() у внешнего объекта BotClient c приветственным сообщением указанном в условии задачи.
2. Метод clientMainLoop() класса BotSocketThread должен вызывать clientMainLoop() у объекта родительского класса (super).
3. Метод processIncomingMessage() должен выводить на экран полученное сообщение message.
4. Метод processIncomingMessage() должен отправлять ответ с помощью метода sendTextMessage() (форматирование согласно условию задачи).
5. Метод processIncomingMessage() не должен вызывать метод sendTextMessage() для некорректных запросов.
 */