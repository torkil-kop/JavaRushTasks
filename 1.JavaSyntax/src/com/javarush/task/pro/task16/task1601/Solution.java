package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date("Sep 24 12:15:00 1986");

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        String str = "";

        switch (date.getDay()) {
            case 0 : str = "Воскресенье";
                break;
            case 1 : str = "Понедельник";
                break;
            case 2 : str = "Вторник";
                break;
            case 3 : str = "Среда";
                break;
            case 4 : str = "Четверг";
                break;
            case 5 : str = "Пятница";
                break;
            case 6 : str = "Суббота";
                break;
        }

        return str;
    }
}
