package com.javarush.task.pro.task18.task1803;

import java.util.Comparator;

/* 
Наставники JavaRush
*/

public class NameComparator implements Comparator<JavaRushMentor>{
    public int compare(JavaRushMentor mentor1, JavaRushMentor mentor2){
        if ((mentor1.getName()).length() < (mentor2.getName()).length()){
            return (mentor1.getName()).length() - (mentor2.getName()).length();
        } else if ((mentor1.getName()).length() > (mentor2.getName()).length()) {
            return (mentor1.getName()).length() - (mentor2.getName()).length();
        }
        else {
            return  0;
        }
    }
}
/*
отрицательное число, если длина имени ментора mentor1 меньше длины имени ментора mentor2;
положительное число, если длина имени ментора mentor1 больше длины имени ментора mentor2;
0, если длины имен менторов mentor1 и mentor2 одинаковы.
 */