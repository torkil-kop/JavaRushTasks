package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.Operation;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> allKnownCommandsMap = new HashMap<>();

    static {

        allKnownCommandsMap.put(Operation.DEPOSIT, new DepositCommand());
        allKnownCommandsMap.put(Operation.INFO, new InfoCommand());
        allKnownCommandsMap.put(Operation.WITHDRAW, new WithdrawCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());

    }


    private CommandExecutor() {
    }
    public static final void execute(Operation operation){
        allKnownCommandsMap.get(operation).execute();
    }

}
/*
4. Создай public класс CommandExecutor, через который можно будет взаимодействовать со всеми командами.
Создай ему статическую карту Map<Operation, Command> allKnownCommandsMap, которую проинициализируй всеми известными нам операциями и командами.

4.1 Создай метод public static final void execute(Operation operation), который будет дергать метод execute у нужной команды.
Реализуй эту логику.
4.2. Расставь правильно модификаторы доступа учитывая, что единственная точка входа - это метод execute.

Проверяем, чтоб структура соответствовала тестам на сервере.
Логику будем переносить в следующем таске.
 */