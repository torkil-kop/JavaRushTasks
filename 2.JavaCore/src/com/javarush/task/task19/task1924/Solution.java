package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) throws IOException {
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           fileName = reader.readLine();
       }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String str = reader.readLine();
                String[] strings = str.split(" ");
                for (Integer i : map.keySet()
                ) {

                    for (int j = 0; j < strings.length; j++) {


                        try {
                            if (Integer.parseInt(strings[j]) == i) {
                                strings[j] = map.get(i);

                            }
                        } catch (Exception ignored) {
                            try {
                                if (Integer.parseInt(strings[j].replaceAll("\\p{Punct}", "")) == i) {
                                    strings[j] = map.get(i) + strings[j].substring(strings[j].length() - 1);
                                }
                            }
                         catch (Exception ignored1) {
                         }
                         }


                    }
                }
                System.out.println(String.join(" ", strings));
            }
        }
    }
}