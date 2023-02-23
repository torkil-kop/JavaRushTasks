package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

class DepositCommand implements Command{

     @Override
     public void execute() {
         String currencyCode = ConsoleHelper.askCurrencyCode();
         String[] currencyCodeInfo = ConsoleHelper.getValidTwoDigits(currencyCode);
         CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
         currencyManipulator.addAmount(Integer.parseInt(currencyCodeInfo[0]), Integer.parseInt(currencyCodeInfo[1]));

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