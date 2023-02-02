package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0] == null) {
            return;
        }
        File file = new File(args[0]);
        Set<Character> set = new TreeSet<>();
        String str;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            while ((str = reader.readLine()) != null) {
                str = str.toLowerCase();
                char[] chars = str.toCharArray();
                for (char c : chars
                ) {
                    if (Character.isLetter(c)) {
                        set.add(c);
                    }
                }
            }
        }
        if (set.size() < 5) {
            for (char c : set
            ) {
                System.out.print(c);
            }
        } else {
            Iterator<Character> characterIterator = set.iterator();
            for (int i = 0; i < 5; i++) {
                System.out.print(characterIterator.next());
            }
        }
    }
}
