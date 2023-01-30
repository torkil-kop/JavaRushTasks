package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.*;

public class Thread5 extends Thread {
    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String reader = bufferedReader.readLine();
            int sum = 0;
            while (true) {
                if (reader.equals("N")) {
                    System.out.println(sum);
                    break;
                }
                try {
                    int r = Integer.parseInt(reader);
                    sum = sum + r;
                   reader = bufferedReader.readLine();
                } catch (Exception e) {
                    reader = bufferedReader.readLine();
                }

            }

            }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
/*
Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
 */
