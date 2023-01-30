package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
          String fileName = reader.readLine();
          reader.close();
        String str = "";

        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName))) {
            while (reader1.ready()) {
                str = reader1.readLine();
                String[] strings = str.split(" ");
                Set<String> set = new HashSet<>(Arrays.asList(strings));
                                int count = 0;

                for (String word : words
                ) {
                    for (String string : set
                    ) {
                        if (word.equals(string)) {
                            count++;
                        }
                    }
                }
                if (count == 2) {
                    System.out.println(str);
                }
            }
        }
    }
}
