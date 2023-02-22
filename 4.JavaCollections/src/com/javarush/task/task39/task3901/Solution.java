package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder("");
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!str.toString().contains(c +"")) {
                    str.append(c);
                    if (j == s.length() - 1) {
                        set.add(str.length());
                    }
                }else {
                    set.add(str.length());
                    j = s.length() ;
                }
            }

        }
        return set.last();
    }
}
/*
Например, для строки "a123bcbcqwe" - 6, а для строки "ttttwt" - 2.
 */