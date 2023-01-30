package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int count = 0;
        char symbol;
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            while (inputStream.available() > 0) {
                int b = inputStream.read();
                symbol = (char) b;
                if (symbol == ','){
                    count++;
                }
            }
            inputStream.close();
            System.out.println(count);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
