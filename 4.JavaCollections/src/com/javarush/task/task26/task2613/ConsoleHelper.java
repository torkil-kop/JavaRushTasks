package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleHelper {
    private final static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {

        System.out.println(message);
    }

    public static String readString() {
        String s = "";
        try {
            s = bis.readLine();
        } catch (Exception ignored) {
        }
        return s;
    }

    public static String askCurrencyCode() {
        writeMessage("Введите код валюты");
        String currencyCode = "";
        while (true) {
            if ((currencyCode = readString()).length() == 3) {
                currencyCode = currencyCode.toUpperCase();
                break;
            } else {

                writeMessage("Данные не корректны, введите код валюты снова");
            }
        }
        return currencyCode;
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        writeMessage("Введите два целых положительных числа через пробел - Номинал и кол-во банкнот");

        String[] ss;

        while (true) {
            try {
                ss = bis.readLine().split(" ");

                if (Integer.parseInt(ss[0]) > 0 && Integer.parseInt(ss[1]) > 0 && ss.length == 2) {
                    break;
                }
                else {
                    writeMessage("Введены некорректные числа. Введите два целых положительных числа");
                }
            } catch (Exception e) {
                writeMessage("Введены некорректные числа. Введите два целых положительных числа");
            }
        }
        return ss;
    }
}
/*
3. Чтобы считать номинал и количество банкнот, добавим статический метод String[] getValidTwoDigits(String currencyCode) в ConsoleHelper.
Этот метод должен предлагать пользователю ввести два целых положительных числа.
Первое число - номинал, второе - количество банкнот.
Никаких валидаторов на номинал нет. Т.е. 1200 - это нормальный номинал.
Если данные некорректны, то сообщить об этом пользователю и повторить.

Пример вводимых данных:
200 5
 */