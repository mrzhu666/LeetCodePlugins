package test;

import java.util.*;
import java.lang.*;

public class SetTest {
  public static void main(String[] args) {
    Set<List<Integer>> s=new HashSet<>();
    s.add(Arrays.asList(1,2,3));
    s.add(new ArrayList<>(Arrays.asList(1,2,3)));
    System.out.println(s);
    System.out.println(s.contains(new ArrayList<>(Arrays.asList(3,2,1))));

    System.out.println(s.contains(Arrays.asList(1,2,3)));


  }
}