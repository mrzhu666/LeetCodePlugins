package test;

import java.util.*;
import java.lang.*;

public class MapTest2 {
  public static void main(String[] args) {
      Map<List<Integer>,Integer> dp=new HashMap<>();
      dp.put(new ArrayList<>(Arrays.asList(1,2)),1);
      System.out.println(dp.get(new ArrayList<>(Arrays.asList(1,2))));
  }
}