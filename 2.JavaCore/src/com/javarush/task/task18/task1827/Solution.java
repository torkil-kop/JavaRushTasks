package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0){
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        if (args[0].equals("-c")) {
            try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName)); BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                String str;
                int max = 0;
                while (reader1.ready()) {
                    str = reader1.readLine();
                    StringBuilder stringBuilder = new StringBuilder(str);
                    String result = stringBuilder.substring(0, 8).trim();
                    int number = Integer.parseInt(result);
                    max = Math.max(number, max);
                }
                max++;
                String ss = max + "";
                if (ss.length() < 8) {
                    for (int i = ss.length(); i < 8; i++) {
                        ss = ss + " ";
                    }
                }
                String productName = args[1];
                if (productName.length() > 30) {
                    productName = productName.substring(0, 30);
                } else {
                    for (int i = productName.length(); i < 30; i++) {
                        productName = productName + " ";
                    }
                }
                String price = args[2];
                if (price.length() > 8) {
                    price = price.substring(0, 8);
                } else {
                    for (int i = price.length(); i < 8; i++) {
                        price = price + " ";
                    }
                }
                String quantity = args[3];
                if (quantity.length() > 4) {
                    quantity = quantity.substring(0, 4);
                } else {
                    for (int i = quantity.length(); i < 4; i++) {
                        quantity = quantity + " ";
                    }
                }
                String finalStr = ss + productName + price + quantity;
                writer.write("\n" + finalStr);
            }
        }
    }
}
