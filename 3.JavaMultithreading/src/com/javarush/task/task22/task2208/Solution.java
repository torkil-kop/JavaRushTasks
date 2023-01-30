package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> pp = new HashMap<>();
        pp.put(null, null);
        pp.put(null, null);
        pp.put(null, null);
        pp.put(null, null);

        System.out.println(getQuery(pp));
    }

    public static String getQuery(Map<String, String> params) {
        String str = "";
        StringBuilder stringBuilder = new StringBuilder(str);
        for (Map.Entry<String, String> string : params.entrySet()
        ) {
            //System.out.println(string.getValue());
            if (string.getValue() !=null) {
                stringBuilder.append(string.getKey() + " = '" + string.getValue() + "' and ");
            }
        }
        String str2 = stringBuilder.toString();
        if (!str2.isEmpty()) {
            str2 = str2.substring(0, str2.length() - 5);
        }
        return str2;
    }
}
/*
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
 */