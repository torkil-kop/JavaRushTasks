package com.javarush.task.pro.task10.task1016;

/* 
Прогноз погоды
*/

public class Solution {

    public static void showWeather(City city) {
        String city1 = city.getName();
        int temperature1 = city.getTemperature();
        System.out.println("В городе " + city1 + " сегодня температура воздуха " + temperature1);
    }

    public static void main(String[] args) {
        City city = new City("Дубай", 40);
        showWeather(city);
    }
}
