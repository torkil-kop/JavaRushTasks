package com.javarush.task.pro.task17.task1715;

import java.util.ArrayList;
import java.util.List;

/* 
Вилларибо и Виллабаджо.
*/

public class Solution {
    static List<MusicalInstrument> orchestra = new ArrayList<>();

    public static void main(String[] args) {
        createKeyboardOrchestra();
        createStringedOrchestra();
        playOrchestra();
    }

    public static void createKeyboardOrchestra() {
        orchestra.add(new Organ());
        orchestra.add(new Piano());
        orchestra.add(new Piano());
        orchestra.add(new Piano());
    }

    public static void createStringedOrchestra() {
        orchestra.add(new Violin());
        orchestra.add(new Violin());
        orchestra.add(new Guitar());
    }

    public static void playOrchestra() {
        for (MusicalInstrument mi : orchestra) {
if  (mi instanceof Guitar){
    Guitar guitar = (Guitar) mi;
    guitar.play();
} else if (mi instanceof Organ) {
    Organ organ = (Organ) mi;
    organ.play();
} else if (mi instanceof Piano) {
    Piano piano = (Piano) mi;
    piano.play();
} else if (mi instanceof Violin) {
    Violin violin = (Violin) mi;
    violin.play();
}
        }
    }
}
