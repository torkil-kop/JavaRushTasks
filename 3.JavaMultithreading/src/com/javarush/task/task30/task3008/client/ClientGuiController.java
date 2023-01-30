package com.javarush.task.task30.task3008.client;

import java.io.IOException;

public class ClientGuiController extends Client{
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);
    public class GuiSocketThread extends SocketThread{
        public void processIncomingMessage(String message){
            model.setNewMessage(message);
            view.refreshMessages();
        }
        public void informAboutAddingNewUser(String userName){
            model.addUser(userName);
            view.refreshUsers();
        }
        public void informAboutDeletingNewUser(String userName){
            model.deleteUser(userName);
            view.refreshUsers();
        }
        public void notifyConnectionStatusChanged(boolean clientConnected){
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    @Override
    public void run() {
        getSocketThread().run();
    }

    @Override
    protected String getServerAddress() throws IOException, ClassNotFoundException {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }
    public ClientGuiModel getModel(){
        return model;
    }

    public static void main(String[] args) {
       new ClientGuiController().run();
    }
}
/*
В нем переопредели следующие методы:
а) void processIncomingMessage(String message) - должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления.
б) void informAboutAddingNewUser(String userName) - должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения.
в) void informAboutDeletingNewUser(String userName) - должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.
г) void notifyConnectionStatusChanged(boolean clientConnected) - должен вызывать аналогичный метод у представления.
5. Переопредели методы в классе ClientGuiController:
а) SocketThread getSocketThread() - должен создавать и возвращать объект типа GuiSocketThread.
б) void run() - должен получать объект SocketThread через метод getSocketThread() и вызывать у него метод run().
Разберись, почему нет необходимости вызывать метод run() в отдельном потоке, как мы это делали для консольного клиента.
в) getServerAddress(), getServerPort(), getUserName().
Они должны вызывать одноименные методы из представления (view).
6. Реализуй метод ClientGuiModel getModel(), который должен возвращать модель.
7. Реализуй метод main(), который должен создавать новый объект ClientGuiController и вызывать у него метод run().
Запусти клиента с графическим окном, нескольких консольных клиентов и убедись, что все работает корректно.
 */