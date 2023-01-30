package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {

        public static void main(String... args) {
            String fileName = args[0];
            long numberPosition = Long.parseLong(args[1]);
            String text = args[2];
            byte[] b = text.getBytes();
            byte[] bytes = new byte[b.length];
            byte[] bytesTrue = "true".getBytes();
            byte[] bytesFalse = "false".getBytes();
            try (RandomAccessFile  randomAccessFile = new RandomAccessFile(fileName, "rw")){
randomAccessFile.seek(numberPosition);
                    randomAccessFile.read(bytes, 0 , bytes.length);
                randomAccessFile.seek(randomAccessFile.length());
//                System.out.println(Arrays.toString(b));
//                System.out.println(Arrays.toString(bytes));
//                System.out.println(new String(bytes));
                    if (Arrays.equals(b, bytes)){

                        randomAccessFile.write(bytesTrue);
                    }
                    else {
                        randomAccessFile.write(bytesFalse);
                    }

            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
    }
/*
Используем RandomAccessFile
В метод main приходят три параметра:
1) fileName - путь к файлу;
2) number - число, позиция в файле;
3) text - текст.

Считать текст с файла начиная с позиции number, длиной такой же как и длина переданного текста в третьем параметре.
Если считанный текст такой же как и text, то записать в конец файла строку 'true', иначе записать 'false'.
Используй RandomAccessFile и его методы seek(long pos), read(byte[] b, int off, int len), write(byte[] b).
Используй один из конструкторов класса String для конвертации считанной строчки в текст.


Requirements:
1. В методе main класса Solution необходимо использовать RandomAccessFile, который должен использовать файл, который приходит первым параметром.
2. В методе main класса Solution программа должна устанавливать позицию в файле, которая передана во втором параметре.
3. В методе main класса Solution программа должна считывать данные с файла при помощи метода read(byte[] b, int off, int len).
4. Запись должна происходить в конец файла.
5. Если считанный текст такой же как и text, то программа должна записать в конец переданного файла строку 'true'.
6. Если считанный текст НЕ такой же как и text, то программа должна записать в конец переданного файла строку 'false'.
 */