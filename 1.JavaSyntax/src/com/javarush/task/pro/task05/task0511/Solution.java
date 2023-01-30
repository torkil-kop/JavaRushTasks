package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int N = console.nextInt();
        multiArray = new int[N][];
        for (int i = 0; i < N; i++) {
            int x = console.nextInt();
            multiArray[i] = new int[x];
        }
        /*for (int i4 = 0; i4 < N; i4++) {
            for (int j2 = 0; j2 < multiArray[i4].length; j2++) {
                System.out.print(multiArray[i4][j2] + " ");
            }
            System.out.println("");
                          }

         */
    }
}
