package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();


    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s;
            boolean notExit = true;
            while (notExit) {
                s = reader.readLine();
               if (!s.equals("exit")){
                   list.add(s);
                }
               else {
                   for (String fileName: list
                        ) {
                       ReadThread readThread = new ReadThread(fileName);
                   }
                   notExit = false;
               }
            }
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        private ArrayList<Integer> integerArrayList = new ArrayList<>();

        public ReadThread(String fileName) {
            this.fileName = fileName;
            this.start();
        }

        @Override
        public void run() {
           int maxInt = 0;
           int max2 = 0;
           int finalInt = 0;
            try {
                //BufferedReader reader = new BufferedReader(new FileReader(fileName));
                FileInputStream inputStream = new FileInputStream(fileName);
                while (inputStream.available () > 0) {
                   integerArrayList.add(inputStream.read());
                }
                for (Integer max: integerArrayList
                     ) {
                  max2 = Collections.frequency(integerArrayList, max);
                    //maxInt = max2 > maxInt? max2 : maxInt;
                    if (max2 > maxInt){
                        maxInt = max2;
                        finalInt = max;
                    }
                }

                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            resultMap.put(fileName, finalInt);
           // System.out.println(finalInt);

        }

    }
}
/*
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.


Requirements:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
 */