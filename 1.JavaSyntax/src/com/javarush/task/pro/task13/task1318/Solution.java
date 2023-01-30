package com.javarush.task.pro.task13.task1318;

/* 
Следующий месяц, пожалуйста
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getNextMonth(Month.JANUARY));
        System.out.println(getNextMonth(Month.JULY));
    }

    public static Month getNextMonth(Month month) {
        Month nextMonth1 = month;
        int index = nextMonth1.ordinal();
        if (index + 1 <= 11) {
             return Month.values()[index + 1];
        } else
            return  Month.values()[0];
            }

}
