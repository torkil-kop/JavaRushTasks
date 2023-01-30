package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int minNumber = Math.min(number1, number2);
        int maxNumber = Math.max(number1, number2);
        for (int i = minNumber; i > 0; i--) {
            if (maxNumber % i == 0 && minNumber % i == 0){
                System.out.println(i);
                break;
            }
        }
    }
}
