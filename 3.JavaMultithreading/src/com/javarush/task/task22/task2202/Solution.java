package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("avaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string)  {
        if (string == null ) {
            throw new TooShortStringException();
        }
        String newString = null;
        int firstIndex;
        int lastIndex;
        String[] strings = string.split(" ");
        if (strings.length >= 5) {
                       firstIndex = string.indexOf(' ');
            lastIndex = firstIndex;
            for (int i = 0; i < 3; i++) {
                lastIndex = string.indexOf(' ', lastIndex + 1);
            }
            String str = string.substring(lastIndex + 1);
            String[] strArray = str.split(" ");
            newString = string.substring(firstIndex + 1, lastIndex + 1);
            newString = newString + strArray[0];
        }
        else {
            throw new TooShortStringException();
        }

        return newString;
    }

    public static class TooShortStringException extends RuntimeException {

    }
}
