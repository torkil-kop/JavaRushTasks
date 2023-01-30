package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1986, 8, 24);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        String str = "";
        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 1 : str = "воскресенье";
                break;
            case 2 : str = "понедельник";
                break;
            case 3 : str = "вторник";
                break;
            case 4 : str = "среда";
                break;
            case 5 : str = "четверг";
                break;
            case 6 : str = "пятница";
                break;
            case 7 : str = "суббота";
                break;
        }

        return str;
    }
}
