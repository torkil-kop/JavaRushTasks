package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue ORDER_QUEUE = new LinkedBlockingQueue<>();
    /*
    В классе Restaurant должно быть создано private final static поле ORDER_QUEUE типа LinkedBlockingQueue.
     */


    public static void main(String[] args) {
        //Tablet tablet1 = new Tablet(1);
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i+1);
            tablet.setQueue(Restaurant.ORDER_QUEUE);
            tablets.add(tablet);
        }

        Cook cook1 = new Cook("DNO_1");
        cook1.setQueue(Restaurant.ORDER_QUEUE);
        Cook cook2 = new Cook("DNO_2");
        cook2.setQueue(Restaurant.ORDER_QUEUE);
//        StatisticManager.getInstance().register(cook1);
//        StatisticManager.getInstance().register(cook2);
        Thread thread = new Thread(cook1);
        thread.start();
        Thread thread2 = new Thread(cook2);
        thread.start();
        Waiter waiter1 = new Waiter();
        cook1.addObserver(waiter1);
        cook2.addObserver(waiter1);
//        for (Tablet tablet: tablets
//             ) {
//            tablet.addObserver(new OrderManager());
//            tablet.addObserver(new OrderManager());
//        }
//        tablet1.addObserver(cook1);


//        tablet1.createOrder();
//        tablet1.createOrder();
//        tablet1.createOrder();
//        tablet1.createOrder();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
        directorTablet.printAdvertisementProfit();
        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread3 = new Thread(randomOrderGeneratorTask);
        thread.start();
    }
}
/*
1. Удали создание хардкоженного планшета и вызова его метода createOrder().
2. Создай второго повара.
3. Зарегистрируй поваров используя класс StatisticManager.
4. Для обоих поваров и всех планшетов расставь зависимость Observer-Observable.
5. Создай список объектов-планшетов 5 штук, инициализируй его в цикле.
6. Создай и запусти трэд на основе объекта RandomOrderGeneratorTask.
7. Через секунду прерви его и посмотри на вывод в консоль.

Уупс, два повара готовят один и тот же заказ 8-О

Такой аутпут получился потому, что Observable информирует всех своих Observer-ов, т.е. планшет направляет свой заказ всем известным ему поварам.
Такое поведение нам не подходит, поэтому будем исправлять его в следующем задании.

P.S. Не забудь остановить тред!
 */