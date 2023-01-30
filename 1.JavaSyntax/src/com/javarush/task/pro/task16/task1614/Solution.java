package com.javarush.task.pro.task16.task1614;

import java.time.Instant;

/* 
Конец времен
*/

public class Solution {

    public static void main(String[] args) {
       // System.out.println(getMaxFromMilliseconds());
        System.out.println(getMaxFromSeconds());
       System.out.println(getMaxFromSecondsAndNanos());
    }

    static Instant getMaxFromMilliseconds() {
      // Instant i1 = Instant.MAX;
       //long n = i1.toEpochMilli();//напишите тут ваш код
//Instant i2 = Instant.ofEpochMilli(n);
        //return i2;
        return Instant.ofEpochMilli(Long.MAX_VALUE);
    }

    static Instant getMaxFromSeconds() {
        Instant i1 = Instant.MAX;
        long n = i1.getEpochSecond();//напишите тут ваш код
        Instant i2 = Instant.ofEpochSecond(n);
        return i2;

            }

    static Instant getMaxFromSecondsAndNanos() {
        Instant i1 = Instant.MAX;
       long n = i1.getEpochSecond ();
       long n1 = i1.getNano();//напишите тут ваш код
        Instant i2 = Instant.ofEpochSecond(n, n1);
       return i2;
        //return Instant.ofEpochSecond(Instant.MAX.getEpochSecond(), Instant.MAX.getNano());
    }
}
