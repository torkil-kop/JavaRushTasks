package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        long[] result = null;
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int s = i;

            int m = String.valueOf(i).length();

            int sMaby = 0;
            for (int j = 0; j < String.valueOf(i).length(); j++) {
                sMaby = sMaby + (int) Math.pow(Integer.parseInt(String.valueOf(String.valueOf(i).charAt(j))), m);
            }
if (i == sMaby){
    list.add((long) i);
}
        }
        //result = list.toArray(new long[0]);
result =list.stream().mapToLong(l -> l).toArray();

        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(100000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
