package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String str = "";
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder(str);
        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName))) {
            while (reader1.ready()) {
                stringBuilder.append((char) reader1.read());
            }
            str = stringBuilder.toString();
            String[] worldSplit = str.split("\\p{P}|\\n|\\r|\\p{Space}");
            for (String world : worldSplit
            ) {
                if (world.equals("world")) {
                    count++;

                }
            }
        }
        System.out.println(count);
    }
}
