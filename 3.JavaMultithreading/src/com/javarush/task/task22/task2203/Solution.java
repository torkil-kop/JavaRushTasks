package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

import java.util.Arrays;

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null){
            throw new TooShortStringException();
        }
        String[] strings = string.split("\t");
        //System.out.println(Arrays.toString(strings));
        if (strings.length<3)
            throw new TooShortStringException();
int firstIndex;
int secondIndex;
firstIndex = string.indexOf("\t");
secondIndex = string.indexOf("\t", firstIndex+1);


        return string.substring(firstIndex+1, secondIndex);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
