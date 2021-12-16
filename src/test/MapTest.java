package test;

import java.util.*;
import java.lang.*;

public class MapTest {
  public class Status{
    int[] s;
    Status(int ...s){
      this.s=s.clone();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Status status = (Status) o;
      return Arrays.equals(s, status.s);
    }

    @Override
    public int hashCode() {
      return Arrays.hashCode(s);
    }
  }
  public static void main(String[] args) {
    Map<Status,Integer> dp=new HashMap<>();
    Status one=new MapTest().new Status(1,2);
    dp.put(one,1);
//    one.s=new int[]{2,3};
    Status two=new MapTest().new Status(1,2);
    System.out.println(one.equals(two));
    System.out.println(dp.get(two));
  }
}