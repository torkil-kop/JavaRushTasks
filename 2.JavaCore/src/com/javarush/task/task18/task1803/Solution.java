package com.javarush.task.task18.task1803;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            while (inputStream.available() > 0){
                int current = inputStream.read();
                list.add(current);
            }
            inputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            int number = Collections.frequency(list, list.get(i));
            max = number > max ? number : max;
        }
        for (int i = 0; i < list.size(); i++) {
            if (Collections.frequency(list, list.get(i)) == max){

                System.out.print(list.get(i) + " ");
               Collections.replaceAll(list, list.get(i), null);

            }
        }

    }
}
