package com.javarush.task.pro.task02.task0215;

import java.util.Scanner;

/* 
Чтение чисел
*/

public class Solution {

    public static void main(String[] args) {
       Scanner console = new Scanner(System.in);
        int number1 = console.nextInt();
        int number2 = console.nextInt();
        int number3 = console.nextInt();
         int number4 = (number1 + number2 + number3)/3;
        //напишите тут ваш код
System.out.println(number4);
    }
}
