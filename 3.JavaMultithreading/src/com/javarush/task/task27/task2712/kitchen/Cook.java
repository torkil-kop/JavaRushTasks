package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
private String name;
private boolean busy;
private LinkedBlockingQueue queue;

    public Cook(String name) {
        this.name = name;
    }

//    @Override
//    public void update(Observable o, Object arg) {
//
//        Order order = (Order) arg;
//            ConsoleHelper.writeMessage("Start cooking - " + arg);
//            setChanged();
//            notifyObservers(arg);
//        CookedOrderEventDataRow row = new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes());
//        StatisticManager.getInstance().register(row);
//    }
    public void startCookingOrder(Order order){
busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        setChanged();
        notifyObservers(order);
        CookedOrderEventDataRow row = new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes());
        StatisticManager.getInstance().register(row);
        try {
            Thread.sleep(order.getTotalCookingTime()*10);
        }
        catch (Exception ignored){

        }
        busy = false;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            try {

                if (!queue.isEmpty()) {
                    this.startCookingOrder((Order) queue.take());
                        }
                    }

             catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
/*
3. Метод void update(Observable observable, Object arg), который необходимо реализовать, принимает два параметра.
- observable - объект, который отправил нам значение
- arg - само значение, в нашем случае - это объект order
На данном этапе мы будем лишь имитировать обработку и выведем в консоль "Start cooking - " + order
 */