package com.javarush.task.pro.task16.task1619;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/* 
Простой шаблон
*/

public class Solution {

    static LocalDateTime localDateTime = LocalDateTime.now();

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyyг. Hч.mмин");//напишите тут ваш код
        String s = dateTimeFormatter.format(localDateTime);
        System.out.println(s);
    }
}
/*
19.03.2020г. 5ч.4мин
 */