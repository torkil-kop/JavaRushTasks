package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        ArrayList<String> strings1 = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>();
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
            while (reader1.ready()) {
                strings1.add(reader1.readLine());
            }
            while (reader2.ready()) {
                strings2.add(reader2.readLine());
            }
        }
        while (true) {
            if (strings1.size() == 0) {
                lines.add(new LineItem(Type.ADDED, strings2.get(0)));
                break;
            }
            if (strings2.size() == 0) {
                lines.add(new LineItem(Type.REMOVED, strings1.get(0)));
                break;
            }
            try {
                if (strings1.get(0).equals(strings2.get(0))) {
                    lines.add(new LineItem(Type.SAME, strings1.get(0)));
                    strings1.remove(0);
                    strings2.remove(0);
                }
                if (!strings1.get(0).equals(strings2.get(0))) {
                    if (strings1.get(1).equals(strings2.get(0))) {
                        lines.add(new LineItem(Type.REMOVED, strings1.get(0)));
                        strings1.remove(0);
                    }
                    if (strings2.get(1).equals(strings1.get(0))) {
                        lines.add(new LineItem(Type.ADDED, strings2.get(0)));
                        strings2.remove(0);
                    }
                }
            } catch (Exception ignored) {

            }
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
