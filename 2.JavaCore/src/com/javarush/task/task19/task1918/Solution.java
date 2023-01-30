package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Знакомство с тегами
*/

public class Solution {

public static ArrayList<String> result = new ArrayList<>();
    private static int[] Method1(String str, String teg) {

        int indexFirst;
        int indexNext;
        indexFirst = str.indexOf("<" + teg);
        indexNext = str.indexOf("</" + teg + ">");
        String strShare = str.substring(indexFirst + teg.length() + 1, indexNext);
        while (strShare.contains("<" + teg)) {
            indexFirst = indexNext + 2;
            indexNext = str.indexOf("</" + teg + ">", indexNext + teg.length() + 3);
            strShare = str.substring(indexFirst + teg.length() + 1, indexNext);
        }
        int[] index = new int[2];
        index[0] = str.indexOf("<" + teg);
        index[1] = indexNext;
        str = str.substring(str.indexOf("<" + teg), indexNext + teg.length() + 3);
        result.add(str);
        //System.out.println(str);
        return index;
    }

    public static void main(String[] args) throws IOException {
        String teg = args[0];
        String str = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        StringBuilder stringBuilder = new StringBuilder(str);
        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName))) {
            while (reader1.ready()) {
                stringBuilder.append(reader1.readLine());
            }
        }
        str = stringBuilder.toString();

        while (str.contains("<" + teg)) {
            int[] index = Solution.Method1(str, teg);
            str = str.substring(0, index[0]) + str.substring(index[0] + teg.length() + 2, index[1]) + str.substring(index[1] + teg.length() + 3);
        }
        for (String str1: result
             ) {
            System.out.println(str1);
        }
    }
}
