package com.javarush.task.task26.task2613;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] currencyCodeInfo = ConsoleHelper.getValidTwoDigits(currencyCode);
        CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode).addAmount(Integer.parseInt(currencyCodeInfo[0]),
                Integer.parseInt(currencyCodeInfo[1]));

    }
}
/*
4. Метод main класса CashMachine должен считывать с консоли код валюты, потом считывать номинал и количество банкнот, а потом добавлять их в манипулятор.
 */