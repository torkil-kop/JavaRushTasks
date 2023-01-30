package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/

public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Tree oldTree = (Tree) super.clone();
            String newName = new String(oldTree.getName());
            String[] newBranches = new String[oldTree.branches.length];
            for (int i = 0; i < newBranches.length; i++) {
                String newS = new String(oldTree.branches[i]);
                newBranches[i] = newS;
            }
            Tree newTree = new Tree(newName, newBranches);
            return newTree;
        }

        public String[] getBranches() {
            return branches;
        }
    }

}
