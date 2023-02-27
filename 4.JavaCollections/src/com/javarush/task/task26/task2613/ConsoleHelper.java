package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common_en");
    private final static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {

        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String s = "";
        try {
            s = bis.readLine();
            if (s.equalsIgnoreCase(Operation.EXIT.name())) {
//                CommandExecutor.execute(Operation.EXIT);
                throw new InterruptOperationException();
            }
        }
        catch (InterruptOperationException e){
            throw new InterruptOperationException();
        } catch (Exception ignored) {

        }
        return s;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode = "";
        while (true) {
            if ((currencyCode = readString()).length() == 3) {
                currencyCode = currencyCode.toUpperCase();
                break;
            } else {

                writeMessage(res.getString("invalid.data"));
            }
        }
        return currencyCode;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(res.getString("choose.denomination.and.count.format"));

        String[] ss;

        while (true) {
            try {
                ss = ConsoleHelper.readString().split(" ");

                if (Integer.parseInt(ss[0]) > 0 && Integer.parseInt(ss[1]) > 0 && ss.length == 2) {
                    break;
                } else {
                    writeMessage(res.getString("invalid.data"));
                }
            }
            catch (InterruptOperationException e) {
                throw new InterruptOperationException();
            }
                        catch (Exception e) {
                            writeMessage(res.getString("invalid.data"));
            }
        }
        return ss;
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage(res.getString("choose.operation"));
            try {
                int operationNumber = Integer.parseInt(ConsoleHelper.readString());
                return Operation.getAllowableOperationByOrdinal(operationNumber);

            } catch (InterruptOperationException e) {
                throw new InterruptOperationException();
            }
            catch (Exception e) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }
    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
/*
the.end=Terminated. Thank you for visiting JavaRush cash machine. Good luck.
choose.operation=Please choose an operation desired or type 'EXIT' for exiting
operation.INFO=INFO
operation.DEPOSIT=DEPOSIT
operation.WITHDRAW=WITHDRAW
operation.EXIT=EXIT
invalid.data=Please specify valid data.
choose.currency.code=Please choose a currency code, for example USD
choose.denomination.and.count.format=Please specify integer denomination and integer count. For example '10 3' means 30 %s
 */