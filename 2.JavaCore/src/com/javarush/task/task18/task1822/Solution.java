package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String str;
        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName))){
            while (reader1.ready()){
                str = reader1.readLine();
                int x = str.indexOf(" ");
             String str2 = str.substring(0, x);
                int result = Integer.parseInt(str2);
                if (Integer.parseInt(args[0]) == result){
                    System.out.println(str);
                }
            }
        }
    }
}
