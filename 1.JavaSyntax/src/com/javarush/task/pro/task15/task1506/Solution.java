package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;



/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       try (Scanner scanner = new Scanner(System.in)){
          List<String> reader = Files.readAllLines(Paths.get(scanner.nextLine()));
           char [] chars = reader.toString().toCharArray();
           //char [] chars = new char[]{1, ',' , 'e', 'w', ' ', '.'};
            for (char ch: chars) {
                if (ch == (',') | ch == ('.') | ch == (' ')){
                    continue;
                }
                else {
                    System.out.print(ch);
                }
                            }
        //FileReader reader = Files.readAllLines(Paths.get(scanner.nextLine())){

        }
        catch (IOException e){
            System.out.println("Something went wrong : " + e);
       }

    }
}

