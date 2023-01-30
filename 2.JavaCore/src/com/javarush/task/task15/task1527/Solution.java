package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        int indexStart = url.indexOf("?");
        String urlStart = url.substring(indexStart +1);
        if (urlStart.contains("&")) {
            StringTokenizer tokenizer = new StringTokenizer(urlStart, "&");
            while (tokenizer.hasMoreTokens()) {
String token = tokenizer.nextToken();
if (token.contains("=") && token.contains("obj")){
    int indexRavno = token.indexOf("=");
    String s = token.substring(0, indexRavno);
    String s2 = token.substring(indexRavno+1);
   list.add(s);
   list2.add(s2);
} else if (token.contains("=")) {
    int indexRavno = token.indexOf("=");
    String s = token.substring(0, indexRavno);
    list.add(s);
} else {
    list.add(token);
}
            }
        }
        else {
            if (urlStart.contains("=") && urlStart.contains("obj")){
                int indexRavno = urlStart.indexOf("=");
                String s = urlStart.substring(0, indexRavno);
                String s2 = urlStart.substring(indexRavno+1);
                list.add(s);
                list2.add(s2);
            } else if (urlStart.contains("=")) {
                int indexRavno = urlStart.indexOf("=");
                String s = urlStart.substring(0, indexRavno);
                list.add(s);
            } else {
                list.add(urlStart);
            }
        }
        for (String s: list
             ) {
            System.out.print(s + " ");
        }
        System.out.println("");
        for (String s: list2
             ) {
            try {
            double d = Double.parseDouble(s);
                alert(d);
            }
            catch (Exception e){
               alert(s);
            }
        }

/*
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

String str = "Good news everyone!";

StringTokenizer tokenizer = new StringTokenizer(str,"ne");
while (tokenizer.hasMoreTokens())
{
   String token = tokenizer.nextToken();
   System.out.println(token);
}
 */
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
