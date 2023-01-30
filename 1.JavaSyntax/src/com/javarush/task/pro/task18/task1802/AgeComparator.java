package com.javarush.task.pro.task18.task1802;

import java.util.Comparator;

/* 
Сортировка по возрасту
*/

public class AgeComparator implements Comparator<Student>  {
    public int compare (Student student1, Student student2) {
        if (student1.getAge() > student2.getAge()) {
            return student2.getAge() - student1.getAge();
        } else if (student1.getAge() < student2.getAge()) {
            return student2.getAge() - student1.getAge();
        }
//else if (student1.getAge() == student2.getAge()) {
        return 0;
    }
}

/*
Твоя задача — реализовать этот компаратор. Для этого в классе AgeComparator нужно имплементировать интерфейс Comparator<Student> и реализовать метод int compare(Student student1, Student student2), который возвращает числовое значение со следующими условиями:

отрицательное число, если возраст студента student1 больше возраста студента student2;
положительное число, если возраст студента student1 меньше возраста студента student2;
0, если возраст студентов student1 и student2 одинаковый.
Метод main() не принимает участие в тестировании.


Requirements:
1. В классе AgeComparator нужно реализовать интерфейс Comparator<Student>.
2. В классе AgeComparator нужно создать публичный метод int compare(Student, Student).
3. Метод compare(Student, Student) нужно реализовать согласно условию.
 */