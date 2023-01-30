package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;

/* 
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
      LocalDate now = LocalDate.now();

        return now;
    }

    static LocalDate ofExample() {
        LocalDate past = LocalDate.of(2020, 9, 12);

        return past;
    }

    static LocalDate ofYearDayExample() {
        LocalDate past = LocalDate.ofYearDay(2020, 256);

        return past;
    }

    static LocalDate ofEpochDayExample() {
        LocalDate pp = LocalDate.ofEpochDay(18517);

        return pp;
    }
}
