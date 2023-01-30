package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String productName = null;
        String price = null;
        String quantity = null;
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName))) {
            String str;
            if (args[0].equals("-u")) {
                while (reader1.ready()) {
                    str = reader1.readLine();
                    StringBuilder stringBuilder = new StringBuilder(str);
                    String result = stringBuilder.substring(0, 8).trim();
                    if (!result.equals(args[1])) {
                        list.add(str);
                    } else {
                        if (result.length() < 8) {
                            for (int i = result.length(); i < 8; i++) {
                                result = result + " ";
                            }
                        }
                        productName = args[2];
                        if (productName.length() > 30) {
                            productName = productName.substring(0, 30);
                        } else {
                            for (int i = productName.length(); i < 30; i++) {
                                productName = productName + " ";
                            }
                        }
                        price = args[3];
                        if (price.length() > 8) {
                            price = price.substring(0, 8);
                        } else {
                            for (int i = price.length(); i < 8; i++) {
                                price = price + " ";
                            }
                        }
                        quantity = args[4];
                        if (quantity.length() > 4) {
                            quantity = quantity.substring(0, 4);
                        } else {
                            for (int i = quantity.length(); i < 4; i++) {
                                quantity = quantity + " ";
                            }
                        }
                        String finalStr = result + productName + price + quantity;
                        list.add(finalStr);
                    }
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for (String s : list
                ) {
                    writer.write(s + "\n");
                }
                writer.flush();
                writer.close();
            }
            if (args[0].equals("-d")) {
                while (reader1.ready()) {
                    str = reader1.readLine();
                    StringBuilder stringBuilder = new StringBuilder(str);
                    String result = stringBuilder.substring(0, 8).trim();
                    if (!result.equals(args[1])) {
                        list.add(str);
                    }
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for (String s : list
                ) {
                    writer.write(s + "\n");
                }
                writer.flush();
                writer.close();
            }
        }
    }
}