package com.javarush.task.pro.task05.task0519;

import java.util.Arrays;

/* 
Есть ли кто?
*/

public class Solution {

    public static int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static int element = 5;
     public static void main(String[] args) {
        int[] mas = Arrays.copyOf(array, array.length);
       Arrays.sort(mas);
        int index1 = Arrays.binarySearch(mas, element);
        if (index1 >= 0)
            System.out.println(true);
        else
            System.out.println(false);
    }
}
