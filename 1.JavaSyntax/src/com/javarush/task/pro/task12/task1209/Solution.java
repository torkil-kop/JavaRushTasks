package com.javarush.task.pro.task12.task1209;

import java.util.ArrayList;

/* 
Бухгалтерия
*/

public class Solution {
    public static ArrayList<String> waitingEmployees = new ArrayList<>();
    public static ArrayList<String> alreadyGotSalaryEmployees = new ArrayList<>();

    public static void initEmployees() {
        waitingEmployees.add("Гвинно");
        waitingEmployees.add("Гунигерд");
        waitingEmployees.add("Боргелейф");
        waitingEmployees.add("Нифрод");
        waitingEmployees.add("Альбиуф");
        waitingEmployees.add("Иногрим");
        waitingEmployees.add("Фриле");
           }

    public static void main(String[] args) {
        initEmployees();
        for (int i = 0; i < waitingEmployees.size(); i++) {
            paySalary(waitingEmployees.get(i));
                    }
        //System.out.println(waitingEmployees.toString());
        //System.out.println(alreadyGotSalaryEmployees.toString());
        //System.out.println(waitingEmployees.size());
    }

    public static void paySalary(String name) {
       if (waitingEmployees.contains(name)) {
            alreadyGotSalaryEmployees.add(name);
            waitingEmployees.set(waitingEmployees.indexOf(name), null);
      }
    }
}
/*
Requirements:
1. Метод paySalary(String) должен добавлять в список alreadyGotSalaryEmployees имя сотрудника, если он есть в списке waitingEmployees.
2. Метод paySalary(String) должен заменять имя сотрудника на значение null, если он есть в списке waitingEmployees.
3. Метод paySalary(String) не должен изменять списки waitingEmployees и alreadyGotSalaryEmployees, если переданного имени нет в списке waitingEmployees.
4. Если в метод paySalary(String) передается null, метод не должен добавлять это значение в waitingEmployees или alreadyGotSalaryEmployees.
*/
