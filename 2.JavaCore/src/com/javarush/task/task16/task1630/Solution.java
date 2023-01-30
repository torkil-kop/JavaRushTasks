package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            firstFileName = bufferedReader.readLine();
            secondFileName = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//напишите тут ваш код

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String fileName;
        String fileContent = "";
        @Override
        public void setFileName(String fullFileName) {
this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }

        @Override
        public void run() {
            String s;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
while ((s = bufferedReader.readLine())!=null){
    fileContent = fileContent + s + " ";
}
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
/*
5. Метод run класса ReadFileThread должен считывать строки из файла, установленного методом setFileName. А метод getFileContent, этого же класса, должен возвращать вычитанный контент. Возвращаемое значение - это одна строка, состоящая из строк файла, разделенных пробелами.
6. Метод systemOutPrintln должен вызывать метод join у созданного объекта f.
7. Вывод программы должен состоять из 2х строк. Каждая строка - содержимое одного файла.
 */