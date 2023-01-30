package com.javarush.task.task19.task1925;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
     BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))){
    while (reader.ready()){
       // String[] stringsArray = reader.readLine().replaceAll("\\p{Punct}", "").split(" ");
        String[] stringsArray = reader.readLine().split(" ");
        for (String str: stringsArray
             ) {
            if (str.length()>6){
                strings.add(str);

            }
        }

    }

    writer.write(String.join(",", strings));
}

    }

}
