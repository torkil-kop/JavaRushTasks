package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            int first = 0;
            //list.add(inputStream.read());
            while (inputStream.available() > 0) {
                int current = inputStream.read();
               if (current > list.get(list.size() - 1)) {
                    list.add(current);
                }
                //System.out.println(current + " ");
            }

            inputStream.close();
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
