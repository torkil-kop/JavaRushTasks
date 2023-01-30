package com.javarush.task.pro.task05.task0512;

/* 
Создаем мультимассив
*/

public class Solution {

    public static int[][][] multiArray = new int[][][]{{{4, 8, 15}, {16}}, {{23, 42}, {}}, {{1}, {2}, {3}, {4, 5}}};

    public static void main(String[] args) {
        for (int i1 = 0; i1 < multiArray.length; i1++) {
            for (int i4 = 0; i4 < multiArray[i1].length; i4++) {
                for (int j2 = 0; j2 < multiArray[i1][i4].length; j2++) {
                    System.out.println(multiArray[i1][i4][j2]);
                }
            }
        }
    }
}
