package com.waffles.tablemap.example;

import java.util.Arrays;
import java.util.Collection;

import com.waffles.tablemap.TableMap;

public class Example {
  public static void main(String[] args) {
    
    
    Collection<Integer> ints = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31});
    TableMap<Integer, Integer, Integer> multiplicationTable = new TableMap<Integer, Integer, Integer>(ints, ints, Integer.class);
    for(Integer integ : ints) {
      for (Integer integ2 : ints) {
        multiplicationTable.set(integ, integ2, integ * integ2);
      }
    }
    
    
    for (Integer integ: ints) {
      for (Integer integ2: ints) {
        System.out.println(integ + " x " + integ2 + " = " + multiplicationTable.get(integ, integ2));
      }
    }
  }
}
