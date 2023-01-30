package com.javarush.task.task30.task3003;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
//            while (!Thread.currentThread().isInterrupted()) {

                for (int i = 1; i < 10; i++) {
                    System.out.format("Элемент 'ShareItem-%s' добавлен\n", i);//"Элемент 'ShareItem-N' добавлен"

                    queue.offer(new ShareItem("ShareItem-" + i, i));
                    Thread.sleep(100);
                    if (queue.hasWaitingConsumer()) {
                        System.out.format("Consumer в ожидании!\n");
                    }
                }

//            }
        }
            catch (Exception e){
Thread.currentThread().interrupt();

        }
    }
}
/*
3. В Producer и Consumer реализуй метод run так, чтобы вызов метода interrupt прерывал работу consumer и producer трэдов.

4. Реализация метода run для Producer:
4.1. Используя метод offer добавь в очередь 9 ShareItem-ов с такими параметрами: ("ShareItem-N", N), где N - номер элемента от 1 до 9.
4.2. Перед каждым добавлением выведи фразу "Элемент 'ShareItem-N' добавлен". Используй System.out.format.
4.3. Усыпи трэд на 0.1 секунды.
4.4. Если у очереди есть Consumer, не занятый работой, то выведи фразу "Consumer в ожидании!".
Просмотри методы интерфейса TransferQueue, там есть нужный метод.
 */