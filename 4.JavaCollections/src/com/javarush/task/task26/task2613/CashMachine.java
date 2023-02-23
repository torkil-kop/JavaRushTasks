package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
//        String currencyCode = ConsoleHelper.askCurrencyCode();
//        String[] currencyCodeInfo = ConsoleHelper.getValidTwoDigits(currencyCode);
//        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
//        currencyManipulator.addAmount(Integer.parseInt(currencyCodeInfo[0]), Integer.parseInt(currencyCodeInfo[1]));
//        int totalSumForCurrencyCode = currencyManipulator.getTotalAmount();
//        System.out.println(totalSumForCurrencyCode);
        Operation operation;
do {

   operation = ConsoleHelper.askOperation();
    CommandExecutor.execute(operation);
}while (!operation.equals(Operation.EXIT));
    }
}
/*
Проверим, что там стало с main? Цикл, в котором спрашиваем операцию у пользователя, а потом вызываем метод у CommandExecutor.
И так до бесконечности... надо бы придумать условие выхода из цикла.
Исправь цикл, чтоб он стал do-while. Условие выхода - операция EXIT.
 */