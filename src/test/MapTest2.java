package test;

import java.util.*;
import java.lang.*;

public class MapTest2 {
  public static void main(String[] args) {
      Map<List<Integer>,Integer> dp=new HashMap<>();
      dp.put(new ArrayList<>(Arrays.asList(1,2)),1);
      System.out.println(dp.get(new ArrayList<>(Arrays.asList(1,2))));

      // 有序测试
      TreeMap<Integer,Integer> treeSort=new TreeMap<>();
      treeSort.put(3,3);
      treeSort.put(1,1);
      System.out.println(treeSort);

      Map<Integer, Integer> hash = new HashMap<>();
      hash.put(1,2);
      int value=hash.get(0);
      System.out.println(value);
  }
}