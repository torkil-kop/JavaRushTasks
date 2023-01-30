package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String str;
        reader.close();
        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))){
            while (reader1.ready()){
                str=reader1.readLine();
                String[] split = str.split(" ");
                for (String splitStr: split
                     ) {
                    try {
                        int number = Integer.parseInt(splitStr);
                        writer.write(splitStr + " ");
                    }
                    catch (NumberFormatException ignored){

                    }
                }
            }
        }
    }
}
