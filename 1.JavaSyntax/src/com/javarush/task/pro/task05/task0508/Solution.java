package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {
        strings = new String[6];
        //strings = new String[] {"da", "da", "da", "net", "da", "net1"};
        String[] strings2 = new String[6];
        Scanner console = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            strings[i] = console.nextLine();
        }
        for (int i = 0; i < 6; i++) {
            strings2[i] = strings[i];
        }
        for (int i = 1; i < 6; i++) {
            for (int i2 = i; i2 < 6; i2++) {
                if (strings2[i - 1].equals(strings2[i2])) {
                    strings[i - 1] = null;
                    strings[i2] = null;
                }
            }
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}
