package com.javarush.task.pro.task15.task1504;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in); InputStream input = Files.newInputStream(Paths.get(scanner.nextLine()));  OutputStream output = Files.newOutputStream(Paths.get(scanner.nextLine())) ){
            byte[] buffer = new byte[400];
            while (input.available() > 0)
            {
                int real = input.read(buffer);
                                for (int i = 0; i < (real % 2 == 0 ? real : real - 1); i=i+2) {
                   var bb = buffer[i];
                   buffer[i] = buffer[i+1];
                   buffer[i+1] = bb;

                }
                output.write(buffer, 0, real);
            //String line1 = scanner.nextLine();
           // String line2 = scanner.nextLine();

        }

        }
        catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}
//(buffer2.length % 2 == 0 ? buffer2.length/2 : buffer.length/2 - 1)
