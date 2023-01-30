package com.javarush.task.pro.task05.task0517;

import java.util.Arrays;

/* 
Делим массив
*/

public class Solution {

    public static int[][] result = new int[2][];
    public static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public static void main(String[] args) {
       if (array.length % 2 > 0) {
           int[] array1 = Arrays.copyOfRange(array, 0, array.length / 2 + 1);
           int[] array2 = Arrays.copyOfRange(array, array.length / 2 + 1, array.length);
           result[0] = new int [array1.length];
           result[1] = new int [array2.length];
           for (int i = 0; i < array1.length; i++) {
               result[0][i] = array1[i];
           }
               for (int i = 0; i < array2.length; i++) {
                   result[1][i] = array2 [i];
           }
       }
       else
       {
           int[] array1 = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] array2 = Arrays.copyOfRange(array, array.length / 2, array.length);
        result[0] = new int [array1.length];
        result[1] = new int [array2.length];
        for (int i = 0; i < array1.length; i++) {
            result[0][i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            result[1][i] = array2 [i];
        }
    }
        System.out.println(Arrays.deepToString(result));
    }
}
