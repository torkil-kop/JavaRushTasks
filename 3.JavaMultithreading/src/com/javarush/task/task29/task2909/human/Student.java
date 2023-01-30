package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {

    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }
//    public void incAverageGradeBy01() {
//        averageGrade += 0.1;
//    }
//
//    public void incAverageGradeBy02() {
//        averageGrade += 0.2;
//    }
    public void incAverageGrade(double delta){
        this.setAverageGrade(this.getAverageGrade() + delta);
       // averageGrade += delta;
    }
    /*
       public void setValue(String name, double value) {
           if (name.equals("averageGrade")) {
               averageGrade = value;
               return;
           }
           if (name.equals("course")) {
               course = (int) value;
               return;
           }
       }

       6.1. Замена параметра набором специализированных методов. Замени метод setValue() класса Student специализированными методами setCourse и setAverageGrade.
        */
    public void setCourse (int course){
        this.course = course;
    }
    public void setAverageGrade(double averageGrade){
        this.averageGrade = averageGrade;
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }


    public int getCourse() {
        return course;
    }

    @Override
    public String getPosition() {
        return  "Студент";
    }
}