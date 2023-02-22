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
}
/*
1. Создай класс CurrencyManipulator, который будет хранить всю информацию про выбранную валюту.
Класс должен содержать:
1.1 String currencyCode - код валюты, например, USD. Состоит из трех букв.
1.2 Map<Integer, Integer> denominations - это Map<номинал, количество>.
Чтобы можно было посмотреть, к какой валюте относится манипулятор, добавим геттер для currencyCode.
Очевидно, что манипулятор никак не может функционировать без названия валюты, поэтому добавим конструктор с этим параметром и проинициализируем currencyCode.
 */