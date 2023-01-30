package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        ArrayList<String> strings = new ArrayList<>();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName))) {
            while (reader1.ready()) {
                Collections.addAll(strings, reader1.readLine().split(" "));
            }
        }
        System.out.println(strings);
        StringBuilder result = getLine(strings.toArray(new String[0]));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) {
            return new StringBuilder("");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) {
                continue;
            }
            if(i == (words.length -1)){
                stringBuilder.append(words[i]);
                continue;
            }
            for (int j = 0; j < words.length-1; j++) {
                if (words[j+1] == null) {
                    continue;
                }
                if ((words[i].charAt(words[i].length() - 1) + "").equalsIgnoreCase((words[j + 1].charAt(0) + ""))) {
                    stringBuilder.append(words[i] + " " + words[j + 1] + " ");
                    words[i] = null;
                    words[j+1] = null;
                    j = words.length;
                } else if ((words[i].charAt(0) + "").equalsIgnoreCase((words[j + 1].charAt(words[j+1].length() - 1) + "") )) {
                    stringBuilder.append(words[j+1] + " " + words[i] + " ");
                    words[i] = null;
                    words[j+1] = null;
                    j = words.length;
                }

            }
            if(words[i] != null){
                stringBuilder.append(words[i] + " ");
            }
        }
        return stringBuilder;
    }
}
