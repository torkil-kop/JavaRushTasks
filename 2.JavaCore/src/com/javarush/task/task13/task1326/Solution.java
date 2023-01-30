package com.javarush.task.task13.task1326;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       String fileName = bufferedReader.readLine();
        List<String> list = new ArrayList<>();
       // BufferedReader bufferedReader2 = new BufferedReader(new FileInputStream(System.in));
        //BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(fileInputStream));
while (bufferedReader1.ready()){
    list.add(bufferedReader1.readLine());
}
        //Path path = Path.of(fileName);
        //List<String> list = Files.readAllLines(path);
        List<Integer> listInt = new ArrayList<>();
        for (String s: list            ) {

            int i = Integer.parseInt(s);
            if (i % 2 == 0) {
                listInt.add(i);
            }
        }
        Collections.sort(listInt);
        for (int i: listInt
             ) {
            System.out.println(i);
        }
        bufferedReader.close();
        bufferedReader1.close();
           }
}
