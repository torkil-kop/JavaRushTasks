package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Provider;

public class Aggregator {
    public static void main(String[] args) {
        Provider provider = new Provider(null );
        Controller controller = new Controller(provider);

        controller.scan();

    }
}
/*
5. В методе main() класса Aggregator:
5.1. Создай провайдер. Поскольку реализации стратегии (Strategy) пока нет, то в конструктор провайдера передай null.
5.2. Создай контроллер с этим провайдером.
5.3. В методе main() выведи в консоль созданный экземпляр Controller-а.
 */