package com.javarush.task.pro.task08.task0803;

import java.lang.reflect.Array;
import java.util.Scanner;

/* 
Минимальный элемент массива
*/

public class Solution {

    public static void main(String[] args) {
        int[] intArray = getArrayOfTenElements();
               min(intArray);
       System.out.println(min(intArray));

    }

    public static int min(int[] ints) {
        int min = ints[0];
        for (int number : ints) {
            min = Math.min(min, number);
        //int min = Integer.MAX_VALUE;
       // for (int i = 0; i < 9; i++) {
            //int a = Math.min(ints[i], min);
            //min = a;
        //for (int min = Math.min(ints[], ints[]) : ints)
        }
        return min;
    }

    public static int[] getArrayOfTenElements() {
       Scanner console = new Scanner(System.in);
               int[] intArray = new int[10];

       for (int i = 0; i < 10; i++) {
            intArray[i] = console.nextInt();
        }

        return intArray;
    }
}
