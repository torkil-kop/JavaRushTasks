package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    static Hippodrome game;

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse: horses
             ) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse: horses
        ) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

    }
    public Horse getWinner(){
        double max = 0;
        int index = 0;
        for (int i = 0; i < horses.size(); i++) {
            if(horses.get(i).distance > max){
                max = horses.get(i).distance;
                index = i;
            }
        }
        return horses.get(index);
    }
public void printWinner(){
    System.out.println("Winner is " + getWinner().name + "!");
}
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Artur1", 3, 0));
        horses.add(new Horse("Artur2", 3, 0));
        horses.add(new Horse("Artur3", 3, 0));

        game = new Hippodrome(horses);
game.run();
game.printWinner();

    }

    public List<Horse> getHorses() {
        return horses;
    }
}
/*
В методе main требуется:
a) Создать список лошадей (horses).
б) Создать три объекта "лошадь". Имена придумай сам. Начальная скорость у всех лошадей - 3, дистанция - 0.
в) Добавить созданных лошадей в список horses.
г) Создать объект типа Hippodrome, используя созданный ранее список лошадей, и сохранить этот объект в поле game.
Добавь в класс Hippodrome void методы run, move и print. Без параметров.
 */