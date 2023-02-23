package com.javarush.task.task26.task2613;

import java.util.*;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        currencyCode = currencyCode.toUpperCase();
        if (map.containsKey(currencyCode)) return map.get(currencyCode);
        map.put(currencyCode, new CurrencyManipulator(currencyCode));
        return map.get(currencyCode);
    }
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return  map.values();
    }
}
/*
2.1. В классе CurrencyManipulatorFactory создай статический метод getAllCurrencyManipulators(), который вернет Collection всех манипуляторов.
У тебя все манипуляторы хранятся в карте, не так ли? Если нет, то отрефактори.
 */