package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
    public void addAmount(int denomination, int count){
        if (denominations.containsKey(denomination)){
            denominations.put(denomination, denominations.get(denomination) + count);
        }
        else {
            denominations.put(denomination, count);
        }
    }
    public int getTotalAmount(){
        int totalSum = 0;
        for (Integer i: denominations.keySet()
             ) {
            totalSum +=i*denominations.get(i);
        }
        return totalSum;
    }
    public boolean hasMoney(){
        return !denominations.isEmpty();
    }

}
/*
3. Запустим прогу и сразу первой операцией попросим INFO. Ничего не вывело? Непорядок.
Добавь в манипулятор метод boolean hasMoney(), который будет показывать, добавлены ли какие-то банкноты или нет.

4. В InfoCommand используй метод п.3. и выведи фразу "No money available.", если нет денег в банкомате.
 */