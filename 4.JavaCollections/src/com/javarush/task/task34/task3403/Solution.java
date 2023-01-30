package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.recurse(13);

    }

    public void recurse(int n) {
        if (n <= 1) return;

        int nn = 3;
        if (n % (nn - 1) == 0) {
            System.out.print(nn - 1 + " ");
            recurse(n / (nn - 1));
        } else if (n % nn == 0) {
            System.out.print(nn + " ");
            recurse(n / nn);
        } else if (true) {
            while (true) {
                nn += 2;
                if (n % nn == 0) {
                    System.out.print(nn + " ");
                    if (n != nn) {
                        recurse(n / nn);
                    }
                    break;
                }
            }
        }
    }

}
