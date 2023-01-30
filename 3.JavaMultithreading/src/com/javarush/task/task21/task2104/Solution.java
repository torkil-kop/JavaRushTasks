package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
              if (this == o) return true;
        if (o == null)
            return false;
        if (o.getClass() != this.getClass())
            return false;

        Solution solution = (Solution) o;

      return solution.first == this.first && solution.last == this.last;

        //return solution.first.equals(this.first) && solution.last.equals(this.last);
    }

    public int hashCode() {
        //return 31 * first.hashCode() + last.hashCode();
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
       // s.add(new Solution(null, null));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
/*
        Iterator<Solution> i = s.iterator();
        while (i.hasNext()) {
            System.out.println(i.next().hashCode());
        }

 */
    }
}
/*
public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }
 */
