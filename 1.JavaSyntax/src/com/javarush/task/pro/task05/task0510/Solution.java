package com.javarush.task.pro.task05.task0510;

/* 
Треугольный массив
*/

public class Solution {

    public static int[][] result = new int[10][];

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            result[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                result[i][j] = i + j;
            }
        }
        for (int i4 = 0; i4 < 10; i4++) {
            for (int j2 = 0; j2 < result[i4].length; j2++) {
                System.out.print(result[i4][j2] + " ");
            }
            System.out.println("");
        }
    }
}
