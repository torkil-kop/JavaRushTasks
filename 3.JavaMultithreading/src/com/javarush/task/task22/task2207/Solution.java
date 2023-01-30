package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {

    public static void rekurs(ArrayList<String> strings) {
        while (strings.size() != 0) {
            for (int i = 0; i < strings.size(); i++) {
                StringBuilder stringBuilder1 = new StringBuilder(strings.get(0));
                try {
                    if (stringBuilder1.reverse().toString().equals(strings.get(i + 1))) {
                        result.add(new Pair(strings.get(0), strings.get(i + 1)));
                        strings.remove(i + 1);
                        //strings.remove(0);
                      i = strings.size();
                    }
                } catch (Exception ignored) {
                }
            }
            strings.remove(0);
            rekurs(strings);
        }
    }


    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName))) {
            while (reader1.ready()) {
                stringBuilder.append(reader1.readLine().trim() + " ");
                          }
        }
        Collections.addAll(strings, stringBuilder.toString().trim().split(" "));
              rekurs(strings);
        //System.out.println(result.toString());
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {

        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" : first == null ? second : second == null ? first : first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
