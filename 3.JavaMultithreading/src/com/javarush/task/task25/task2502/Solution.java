package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            if (Wheel.values().length != loadWheelNamesFromDB().length) {
                throw new RuntimeException();

            } else {
                int number = 0;
                String[] strings = loadWheelNamesFromDB();

                for (Wheel wheel : Wheel.values()
                ) {
                    for (int i = 0; i < strings.length; i++) {
                        if (wheel.toString().equals(strings[i])) {
                            number++;
                        }
                    }
                }
                if (number == 4){
                    wheels = new ArrayList<>();
                    for (String str: strings
                         ) {

                        wheels.add(Wheel.valueOf(str));
                    }
                }
                else {
                    throw new RuntimeException();
                }
            }

            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
//        Solution.Car car = new Car();
//        System.out.println(car.wheels.toString());
  }
}
