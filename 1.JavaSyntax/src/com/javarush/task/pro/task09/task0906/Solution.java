package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/*
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        String binaryNumber = "";
        if (decimalNumber <= 0) {
            return "";
        }
        while (decimalNumber != 0) {
            binaryNumber = decimalNumber % 2 + binaryNumber;
            decimalNumber = decimalNumber / 2;
        }
        return binaryNumber;
    }

    public static int toDecimal(String binaryNumber) {
        double decimalNumber = 0;
        if (binaryNumber == "" || binaryNumber == null) {
            return 0;
        }
        char[] arr = binaryNumber.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            decimalNumber = decimalNumber + arr[(arr.length - i-1)] * Math.pow(2, i);

        }
        int x = (int) decimalNumber;
return x;

    }
}
/*
Один из алгоритмов перевода десятичного числа в представление двоичного числа следующий:
while(десятичное число не равно 0) {
двоичное представление = остаток от деления десятичного числа на 2 + двоичное представление
десятичное число = десятичное число / 2
}

Один из алгоритмов перевода представления двоичного числа в десятичное число следующий:
for (int i = 0; i < длины двоичного представления; i++) {
десятичное число = десятичное число + число из двоичного представления * на 2 в степени i
}
 */