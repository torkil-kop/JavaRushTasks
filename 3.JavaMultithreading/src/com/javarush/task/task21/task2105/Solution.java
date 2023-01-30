package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Solution)) return false;
        //if (o.getClass() != this.getClass())            return false;


        Solution n = (Solution) o;
        //return n.first == this.first && n.last == this.last;
       // return n.first.equals(first) && n.last.equals(last);
        if (first != null ? !first.equals(n.first) : n.first != null) return false;
        return last != null ? last.equals(n.last) : n.last == null;
    }
    public int hashCode() {
        //return 31 * first.hashCode() + last.hashCode();
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }
    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
