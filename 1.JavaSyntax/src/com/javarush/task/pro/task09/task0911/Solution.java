package com.javarush.task.pro.task09.task0911;

/* 
Поздравление
*/

public class Solution {
    public static String partyFace = "\uD83E\uDD73";
    public static String balloon = "\uD83C\uDF88";
    public static String gift = "\uD83C\uDF81";
    public static String partyPopper = "\uD83C\uDF89";
    public static String cake = "\uD83C\uDF82";

    public static void main(String[] args) {
        printCongratulation();
    }

    public static void printCongratulation() {
        String happyBirthday = "С днем рождения!";
        String congratulation = partyFace + balloon + partyPopper + cake + gift;
        System.out.println(happyBirthday + congratulation);
    }
}
/*
partyFace — "\uD83E\uDD73"
balloon — "\uD83C\uDF88"
gift — "\uD83C\uDF81"
partyPopper — "\uD83C\uDF89"
cake — "\uD83C\uDF82"
 */