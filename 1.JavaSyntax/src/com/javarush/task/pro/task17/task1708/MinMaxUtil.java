package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil {
    public static int min(int a, int b) {
        return a < b ? a: b;
    }
    public static int min(int a, int b, int c) {
        return a < b ? a: (b < c ? b : c);
    }
    public static int min(int a, int b, int c, int d) {
        return Math.min(a, (Math.min(b, Math.min(c, d))));
    }
    public static int min(int a, int b, int c, int d, int e) {
        return Math.min(a, Math.min(b, (Math.min(c, Math.min(d, e)))));
    }
    public static int max(int a, int b) {
        return a > b ? a: b;
    }
    public static int max (int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    public static int max(int a, int b, int c, int d) {
        return Math.max(a, (Math.max(b, Math.max(c, d))));
    }
    public static int max(int a, int b, int c, int d, int e) {
        return Math.max(a, Math.max(b, (Math.max(c, Math.max(d, e)))));
    }
}



/*
Math.min(a, Math.min(b, c))
 */