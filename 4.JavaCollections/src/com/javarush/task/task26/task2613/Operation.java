package com.javarush.task.task26.task2613;

public enum Operation {
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;
    public static Operation getAllowableOperationByOrdinal(Integer i){
        switch (i){
            case 1:
                return Operation.DEPOSIT;
            case 2:
                return Operation.INFO;
            case 3:
                return Operation.WITHDRAW;
            case 4:

                return Operation.EXIT;
            default:
                throw new IllegalArgumentException();
        }

    }
}

/*
1. В энум Operation добавь статический метод Operation getAllowableOperationByOrdinal(Integer i)
Должен возвращать элемент энума: для 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
На некорректные данные бросать IllegalArgumentException.
 */