package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //Scanner console = new Scanner(System.in);
        // String nameFile = console.nextLine();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        String s = "";
        while (!s.equals("exit")){
            s = reader.readLine();
            writer.write(s + "\n");
                   }
        writer.close();
    }
}






       /* String nameFile = "e:\\111.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            try (BufferedWriter writter = new BufferedWriter(new FileWriter(nameFile))) {
                //Scanner console = new Scanner(System.in);
                //while (console.hasNextLine()) {
                String line;
                line = reader.readLine();
                if (line.equals("exit")) {
                    writter.write(line + "\n");

                            }

                writter.write(line + "\n");


            }
        }
    }
}

       /*while (console.hasNextLine()){
           if (console.nextLine().equals("exit")){
               try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                   try (BufferedWriter writter = new BufferedWriter(new FileWriter(nameFile))) {
                       String line;
                       line = reader.readLine();
                       writter.write(line + "/n");
                   }
               }
               catch (IOException e) {
                   e.printStackTrace();
               }
               break;
           }
           else {
               try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                   try (BufferedWriter writter = new BufferedWriter(new FileWriter(nameFile))) {
                       String line;
                     line = reader.readLine();
                           writter.write(line + "/n");
                       }
                   }
                 catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
    }

        */

/*
Писатель в файл с консоли
В этой задаче тебе нужно:
Прочесть с консоли имя файла.
Считывать строки с консоли, пока пользователь не введет строку "exit".
Записать абсолютно все введенные в п.2 строки в файл: каждую строчку — с новой строки.

Requirements:
1. Программа должна считывать c консоли имя файла.
2. Создай и используй объект типа BufferedWriter.
3. Программа не должна ничего считывать из файловой системы.
4. Программа должна считывать строки с консоли, пока пользователь не введет строку "exit".
5. Программа должна записать все введенные строки (включая "exit", но не включая имя файла) в файл: каждую строчку — с новой строки.
6. Метод main должен закрывать объект типа BufferedWriter после использования.
7. Метод main не должен выводить данные на экран.
 */