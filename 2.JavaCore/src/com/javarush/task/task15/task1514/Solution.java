package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(22d, "dno");
        labels.put(22.2, "dno2");
        labels.put(23d, "dnno");
        labels.put(24d, "dn00o");
        labels.put(25d, "dn0000o");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
