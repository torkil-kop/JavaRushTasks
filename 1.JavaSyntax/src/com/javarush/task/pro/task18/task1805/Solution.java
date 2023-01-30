package com.javarush.task.pro.task18.task1805;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Прощание с лямбда-выражением
*/

public class Solution {

    public static void main(String[] args) {
        var strings = new ArrayList<String>();

        Collections.addAll(strings, "JavaRush", "Amigo", "Java Developer", "CodeGym");

        sortStringsByLength(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void sortStringsByLength(ArrayList<String> strings) {
        /* Comparator<String> comparator = new Comparator<String>() {
                       public int compare(String i1, String i2) {
                return i1.length() - i2.length();
            }
        };
        Collections.sort(strings, comparator);
        */
        Comparator<String> comparator = new StringComparator();
        Collections.sort(strings, comparator);
    }
}
