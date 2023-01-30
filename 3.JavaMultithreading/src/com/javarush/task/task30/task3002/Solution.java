package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if (s.startsWith("0x") || s.startsWith("0X")) {
            s = s.substring(2);
            return String.valueOf(Integer.parseInt(s, 16));
        } else if (s.startsWith("0b") || s.startsWith("0B")) {
            s = s.substring(2);
            return String.valueOf(Integer.parseInt(s, 2));
        } else if (s.startsWith("0")){
            s = s.substring(1);
            return String.valueOf(Integer.parseInt(s, 8));

        }
        return s;
    }
}
/*
Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуй логику метода convertToDecimalSystem, который должен переводить переданную строку в десятичное число
и возвращать его в виде строки.


Requirements:
1. В классе Solution должен существовать метод convertToDecimalSystem(String), возвращающий String.
2. Метод convertToDecimalSystem(String) должен иметь модификаторы доступа: public, static.
3. Метод convertToDecimalSystem(String) должен переводить переданную строку в десятичное число и возвращать его в виде строки.
4. Метод convertToDecimalSystem(String) должен вызывать метод Integer.parseInt(String, int).
 */