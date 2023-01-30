package com.javarush.task.pro.task08.task0801;

import static java.lang.Math.toRadians;

/* 
Утильный класс: часть 1
*/

public class Solution {

    public static double sin(double a) {
        double b = Math.sin( Math.toRadians(a));
        return b;
    }

    public static double cos(double a) {
        double b = Math.cos( Math.toRadians(a));
        return b;
    }

    public static double tan(double a) {
        double b = Math.tan( Math.toRadians(a));
        return b;
    }
}
