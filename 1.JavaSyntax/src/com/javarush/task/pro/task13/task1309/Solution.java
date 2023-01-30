package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("kaa", 4.0);
        grades.put("kaa2", 4.1);
        grades.put("kaa3", 4.5);
        grades.put("kaa4", 4.9);
        grades.put("kaa22", 4.2);
    }
}
