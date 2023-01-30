package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
return null;
    }

    public static String toBinary(String hexNumber) {
        //напишите тут ваш код
        return null;
    }
}
/*
Один из алгоритмов перевода строкового представления двоичного числа в строковое представление шестнадцатеричного числа следующий:

Проверяем длину строки, полученной входящим параметром. Она должна быть кратна 4.
Если это не так, то добавляем нужное количество 0 в начало строки.
Берем каждые четыре символа (бита) и проверяем, какому символу шестнадцатеричной кодировки он соответствует.
 */