package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);

       // in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (FileOutputStream fileOutput = new FileOutputStream("e:\\112.txt");
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
             FileInputStream fiStream = new FileInputStream("e:\\112.txt");
             ObjectInputStream objectStream = new ObjectInputStream(fiStream)
        ) {
            Solution solution = new Solution("e:\\111.txt");
            solution.writeObject("some text");

            outputStream.writeObject(solution);
            outputStream.flush();

            //load object from file
            Solution loadedObject = (Solution) objectStream.readObject();

            loadedObject.writeObject("some text - 2");
        } catch (Exception skipped) {
        }
        /*
        Solution solution = new Solution("e:\\111.txt");
        solution.writeObject("NAX");

        FileOutputStream fileOutputStream = new FileOutputStream("e:\\112.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution);
        outputStream.flush();

        FileInputStream fileInputStream = new FileInputStream("e:\\112.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution newSolution = (Solution) inputStream.readObject();
        inputStream.close();
        newSolution.writeObject("Nax2");

         */
    }
}
/*
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные - writeObject
3) сериализовать класс Solution - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5


 */