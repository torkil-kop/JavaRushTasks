package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(Integer.toHexString(hashCode()), ".tmp");
            path.toFile().deleteOnExit();

            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {

        }
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (Exception e) {
        }
        return 0;
    }
    public void putEntry(Entry entry)  {
        try {
            OutputStream outputStream = Files.newOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(entry);
            objectOutputStream.close();
        } catch (Exception ignored) {
        }
    }
    public Entry getEntry(){
        if (getFileSize() == 0){
            return null;
        }
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path));
            Entry entry = (Entry) objectInputStream.readObject();
            return entry;
        }
        catch (Exception e){

        }
        return null;
    }
    public void remove(){
        try {
            Files.delete(path);
        }
        catch (Exception e){

        }
    }
}
/*
9.4. Добавь в класс методы:
9.4.1. public long getFileSize(), он должен возвращать размер файла на который указывает path.
9.4.2. public void putEntry(Entry entry) - должен сериализовывать переданный entry в файл. Учти, каждый entry может содержать еще один entry.
9.4.3. public Entry getEntry() - должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null.
9.4.4.public void remove() - удалять файл на который указывает path.
Конструктор и методы не должны кидать исключения.
 */