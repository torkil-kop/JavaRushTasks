package com.javarush.task.task27.task2712.kitchen;


import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order{

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        dishes = new ArrayList<>();
        Dish[] dishes1 = Dish.values();

        dishes.add(Dish.values () [(int) (Math.random() * dishes1.length)]);
        dishes.add(Dish.values () [(int) (Math.random() * dishes1.length)]);
        dishes.add(Dish.values () [(int) (Math.random() * dishes1.length)]);
    }
}
/*
а) создай класс TestOrder - наследник Order - в пакете родителя;
б) в классе Order создай protected метод initDishes(), в котором инициализируй dishes. Вызови этот метод в конструкторе;
в) проверь, что в классе Order поле dishes имеет модификатор доступа protected;
г) переопредели initDishes в классе-наследнике TestOrder: проинициализируй поле dishes пустым списком и заполни его случайным набором блюд;
д) вместо создания объекта Order в методе createTestOrder() класса Tablet, создавай объект класса TestOrder.
Остальной функционал метода createTestOrder оставь таким же как в createOrder.

3. Отрефакторь методы createTestOrder() и createOrder(): в одном из методов выдели код, который повторяется в обоих методах, и нажми Ctrl+Alt+M,
введи любое имя метода и нажми ОК. IDEA предложит заменить этот код во втором методе, подтверди.
 */