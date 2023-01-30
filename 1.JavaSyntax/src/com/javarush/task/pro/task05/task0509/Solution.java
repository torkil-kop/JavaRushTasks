package com.javarush.task.pro.task05.task0509;

/* 
Таблица умножения
*/

public class Solution {

    public static int[][] MULTIPLICATION_TABLE;

    public static void main(String[] args) {
        MULTIPLICATION_TABLE = new int[10][10];
        for (int i = 0; i < 10; i++) {
            MULTIPLICATION_TABLE[0][i] = i + 1;
        }
        for (int i2 = 2; i2 < 11; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                MULTIPLICATION_TABLE[i2 - 1][i3] = i2 * MULTIPLICATION_TABLE[0][i3];
            }
        }
        for (int i4 = 0; i4 < 10; i4++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(MULTIPLICATION_TABLE[i4][j] + " ");
            }
            System.out.println("");
        }
    }
}

