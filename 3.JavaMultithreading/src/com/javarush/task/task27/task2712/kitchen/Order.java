package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
       initDishes();
    }

    @Override
    public String toString() {
        if (dishes.size() == 0 || dishes == null){
            return "";
        }
        else {
            return "Your order: " + dishes + " of " + tablet.toString()+ ", cooking time " + this.getTotalCookingTime()+ "min";
        }
    }

    public int getTotalCookingTime(){
        int totalTime = 0;
        for (Dish dish: dishes
             ) {
            totalTime +=  dish.getDuration();
        }
        return totalTime;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();

    }
    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }
}
/*
2. Добавим возможность посчитать продолжительность приготовления всего заказа.
Куда его добавить???
2.1. Если в класс Cook, то повар сможет считать продолжительность приготовления заказа.
Чтобы другие классы могли получить эту информацию, необходимо будет получить доступ к объекту Cook.
2.2. Если в класс Order, то имея доступ к заказу всегда можно узнать продолжительность приготовления.
2.3. Выбери правильное место из п.2.1. и п.2.2. и добавьте метод public int getTotalCookingTime(), который посчитает суммарное время приготовления всех блюд в заказе.
2.4. Добавим вывод в консоль этой информации. Пусть теперь информация о заказе выводится в таком виде:
Your order: [SOUP, JUICE, WATER] of Tablet{number=5}, cooking time 23min
 */