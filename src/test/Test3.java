package test;

import java.math.*;
import java.util.*;
import java.lang.*;

public class Test3 {
  public static void main(String[] args) {
    Map<Integer,Integer> numDigit=new HashMap<>();
    String str=new BigDecimal(Math.pow(2,31)-1+"").toString();
    System.out.println(str);
    numDigit.put(9,1);
    numDigit.put(99-9,2);
    numDigit.put(999-99,3);
    numDigit.put(9999-999,4);
    long sum=0;
    for(long i=1;i<10;i++){
      sum+=(Math.pow(10,i)-Math.pow(10,i-1)-2)*i;
    }
    System.out.println(sum);
    sum=0;
    long[] presum=new long[10];

    for(int i=1;i<10;i++){
      sum+=(Math.pow(10,i)-Math.pow(10,i-1))*i;
      presum[i-1]=sum;
    }
    long numss=8888888889L;
    System.out.println(Arrays.toString(presum));
  }
}