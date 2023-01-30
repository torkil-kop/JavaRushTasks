package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        if (a > b) {
            String str = a + "";
            int aa = a;
            for (int i = 0; i < a-b; i++) {

                str = str + " " + (aa - 1);
                aa--;

            }
            return str.trim();
           // return a + " " + getAllNumbersBetween(a - 1, b);
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
           // return a + " " + getAllNumbersBetween(a + 1, b);
            String str = a + "";
            int aa = a;
            for (int i = 0; i < b-a; i++) {
                str = str + " " + (aa + 1);
                aa++;
            }
            return str.trim();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
       numberB = random.nextInt(1000);

        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}