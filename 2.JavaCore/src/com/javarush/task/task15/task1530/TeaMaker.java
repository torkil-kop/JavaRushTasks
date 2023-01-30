package com.javarush.task.task15.task1530;

public class TeaMaker extends DrinkMaker{
    @Override
    void getRightCup() {
        System.out.println("Берем чашку для чая");
    }

    @Override
    void pour() {
        System.out.println("Заливаем кипятком");
    }

    @Override
    void putIngredient() {
        System.out.println("Насыпаем чай");
    }
}
/*
"Заливаем кипятком"
"Берем чашку для латте"
"Насыпаем чай"
"Берем чашку для чая"
"Заливаем кофе"
"Делаем молоко с пенкой"
 */