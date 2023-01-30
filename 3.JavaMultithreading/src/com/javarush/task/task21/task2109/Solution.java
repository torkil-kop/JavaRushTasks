package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        @Override
        public int hashCode() {
            int result = i;
            result = result * 31 + j * 31;
            return result;

        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || !(obj instanceof A)) return false;
            A a = (A) obj;
            if (i != a.i) return false;
            return (j != a.j);

        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B implements Cloneable {
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new C (getI(), getJ(), getName());
        }

        public C(int i, int j, String name) {
            super(i, j, name);
        }


        public static void main(String[] args) {

        }
    }
}
