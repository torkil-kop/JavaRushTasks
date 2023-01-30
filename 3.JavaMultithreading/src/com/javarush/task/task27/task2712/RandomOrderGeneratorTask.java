package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable{
    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval ) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        try {
            while (true) {
                tablets.get((int) (Math.random() * tablets.size())).createTestOrder();
                Thread.sleep(interval);
            }

        }
        catch (Exception ignored){

        }
    }
}
/*
2. В отдельном классе создай таск (Runnable) RandomOrderGeneratorTask. Этот таск должен:
2.1. Хранить список всех планшетов.
2.2. Используя Math.random выбирать случайный планшет.
2.3. У RandomOrderGeneratorTask должен быть только один единственный метод.
2.4. Генерировать случайный заказ каждые ORDER_CREATING_INTERVAL миллисекунд для планшета из п.2.2 (не печатай стек-трейс).
Сейчас заказ создается в методе createOrder в классе Tablet.
В классе Tablet создай метод void createTestOrder() с похожей функциональностью, который будет случайным образом генерировать заказ со случайными блюдами не общаясь с реальным человеком.
Список планшетов и интервал передай в конструкторе RandomOrderGeneratorTask.
 */