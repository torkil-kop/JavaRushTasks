package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.ArrayList;
import java.util.List;

class InfoCommand implements Command {
    @Override
    public void execute() {
        List<CurrencyManipulator> list = new ArrayList<>(CurrencyManipulatorFactory.getAllCurrencyManipulators());
boolean hasMoney = false;

        for (CurrencyManipulator cM : list
        ) {
            if (cM.hasMoney()) {
                hasMoney = true;
                ConsoleHelper.writeMessage(cM.getCurrencyCode() + " - " + cM.getTotalAmount());
            }
        }
        if (!hasMoney){
            ConsoleHelper.writeMessage("No money available.");
    }


//   int totalSumForCurrencyCode = currencyManipulator.getTotalAmount();
//   System.out.println(totalSumForCurrencyCode);
}
}
/*
В классе InfoCommand в методе execute() для каждого манипулятора выведи: "код валюты - общая сумма денег для выбранной валюты",
если денег нет в банкомате выведи фразу, "No money available.".
 */