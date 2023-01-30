package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       // BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileReader reader = new FileReader(args[0]);
        ArrayList<Integer> characters = new ArrayList<>();
        HashSet<Integer> charactersUnic = new HashSet<>();
        //ArrayList<Integer> charactersFinal = new ArrayList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int c;
        while (reader.ready()){
            c = reader.read();
            characters.add(c);
            charactersUnic.add(c);

        }
        int number = 0;
        for (Integer cc: charactersUnic
             ) {
            number = Collections.frequency(characters, cc);
            treeMap.put(cc, number);

        }
        for(Map.Entry<Integer, Integer> entry: treeMap.entrySet()) {
int dd = entry.getKey();
char dds =(char) dd;
            System.out.println(dds + " " + entry.getValue());
        }
        reader.close();
    }
}
