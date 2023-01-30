package com.javarush.task.task15.task1530;

public abstract class DrinkMaker {
    abstract void getRightCup();

    abstract void putIngredient();

    abstract void pour();

    public void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
/*
void getRightCup() - выбрать подходящую чашку;
void putIngredient() - положить ингредиенты;
void pour() - залить жидкость.
 */