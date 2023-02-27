package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName() + ".resources.";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
//        String currencyCode = ConsoleHelper.askCurrencyCode();
//        String[] currencyCodeInfo = ConsoleHelper.getValidTwoDigits(currencyCode);
//        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
//        currencyManipulator.addAmount(Integer.parseInt(currencyCodeInfo[0]), Integer.parseInt(currencyCodeInfo[1]));
//        int totalSumForCurrencyCode = currencyManipulator.getTotalAmount();
//        System.out.println(totalSumForCurrencyCode);
        Operation operation;
        try {

            do {
                CommandExecutor.execute(Operation.LOGIN);
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException ignored) {
            ConsoleHelper.printExitMessage();
        }
    }
}
/*
Операция LOGIN должна запускаться один раз, до выполнения всех операций.
Не забудь о InterruptOperationException, в любом месте пользователь может завершить работу с банкоматом. Поэтому добавь вызов операции внутрь блока try-catch.
 */