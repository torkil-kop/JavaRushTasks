package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        try {
            String[] currencyCodeInfo = ConsoleHelper.getValidTwoDigits(currencyCode);
            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
            currencyManipulator.addAmount(Integer.parseInt(currencyCodeInfo[0]), Integer.parseInt(currencyCodeInfo[1]));
            ConsoleHelper.writeMessage(res.getString("success.format"));
        } catch (NumberFormatException e) {
    ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }



    }
}
/*
Пора привести в порядок наш main, уж очень там всего много, чего не должно быть.

1. Перенеси логику из main в DepositCommand и InfoCommand.
Проверим, что там стало с main? Цикл, в котором спрашиваем операцию у пользователя, а потом вызываем метод у CommandExecutor.
И так до бесконечности... надо бы придумать условие выхода из цикла.
Исправь цикл, чтоб он стал do-while. Условие выхода - операция EXIT.

4. В классе DepositCommand в методе execute() запроси код валюты, потом запроси номинал и количество банкнот, а потом добавь их в манипулятор.
Если номинал и количество банкнот пользователь ввел не правильно(не числа) - повторять попытку по введению номинала и количества банкнот.
 */