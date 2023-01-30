package com.javarush.task.task26.task2601;

import java.util.*;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
//        Integer[] intArray = new Integer[]{13, 8, 15, 5, 17, 14};//13, 8, 15, 5, 17
//        //System.out.println(Arrays.toString(intArray));
//
//        Integer[] newIntArray = new Integer[intArray.length];
//        newIntArray = Solution.sort(intArray);
//        System.out.println(Arrays.toString(newIntArray));
    }

    public static Integer[] sort(Integer[] array) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(array));
        Collections.sort(arrayList);
        Integer mediana;
        if (arrayList.size() % 2 == 0) {
            mediana = (arrayList.get(arrayList.size() / 2) + arrayList.get(arrayList.size() / 2 - 1))/2 ;
           // arrayList.remove(arrayList.size() / 2 - 1);
        } else {
            mediana = arrayList.get((arrayList.size() - 1) / 2);
            //arrayList.remove((arrayList.size() - 1) / 2);
        }
        /*Map<Integer, Integer> map = new HashMap<>();
        for (Integer ii: arrayList
             ) {
            map.put(ii, Math.abs(mediana - ii));
        }
          */
        Integer[] newArray = new Integer[array.length];
        //newArray[0] = mediana;
        int i = 0;
        while (arrayList.size() > 0) {
            Integer value = Integer.MAX_VALUE;
            Integer diff = Integer.MAX_VALUE;
            int index = 0;

            for (Integer ii : arrayList
            ) {
//              if (Math.abs(mediana - ii) < diff && ii < value){
//                  diff = Math.abs(mediana - ii);
//                  value = ii;
//                  index = arrayList.indexOf(ii);
//              }
                if (Math.abs(mediana - ii) < diff) {
                    diff = Math.abs(mediana - ii);
                    value = ii;
                    index = arrayList.indexOf(ii);
                }
                 else if (Math.abs(mediana - ii) == diff && ii < value){

                       diff = Math.abs(mediana - ii);
                    value = ii;
                    index = arrayList.indexOf(ii);
                }
            }
            newArray[i] = arrayList.get(index);
            arrayList.remove(index);
            i++;
        }
      //  System.out.println(Arrays.toString(newArray));

        return newArray;
    }
}
