package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students
        ) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        List<Student> maxStudents = new ArrayList<>();
        double max = 0;
        for (Student student : students
        ) {
            if (student.getAverageGrade() > max) {
                max = student.getAverageGrade();
                maxStudents.add(student);
            }
        }
        return maxStudents.get(maxStudents.size() - 1);
    }

    /*
        public void getStudentWithMinAverageGradeAndExpel() {
            //TODO:
        }

     */
    public Student getStudentWithMinAverageGrade() {
        //TODO:
        List<Student> minStudents = new ArrayList<>();
        double min = Integer.MAX_VALUE;
        for (Student student : students
        ) {
            if (student.getAverageGrade() < min) {
                min = student.getAverageGrade();
                minStudents.add(student);
            }
        }
        return minStudents.get(minStudents.size() - 1);
    }

    public void expel(Student student){
        students.remove(student);
    }
    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}