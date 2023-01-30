package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanMove {
        public void move();
    }

    public interface CanEat {
        public void eat();
    }

    public abstract class Dog implements CanEat, CanMove{
    }

    public abstract class Duck implements CanMove, CanFly, CanEat {
    }

    public abstract class Car implements CanMove{
    }

    public abstract class Airplane implements CanFly, CanMove {
    }
}
/*
Требования:
•	Класс Solution должен содержать интерфейс CanFly с одним методом fly().
•	Класс Solution должен содержать интерфейс CanMove с одним методом move().
•	Класс Solution должен содержать интерфейс CanEat с одним методом eat().
•	Собака должна уметь передвигаться и есть.
•	Автомобиль должен уметь передвигаться.
•	Самолет должен уметь передвигаться и летать.
•	Утка должна уметь передвигаться, летать и есть.
 */