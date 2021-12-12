package test;

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

class Num{
  static int count=0;
  int num;
  String word;
  Num(String word){
    this.num=count;
    this.word=word;
    count++;
  }
  @Override
  public String toString(){
    return ""+this.num+" "+this.word;
  };
}

public class Test1 {
  public static void main(String[] args) {
    List<String> str= Arrays.asList("a","b","c","a");
    List<Num> nums=str.stream().map(Num::new).collect(Collectors.toList());
    System.out.println(nums);
    Map<String,Set<Integer>> counter=nums.stream().collect(Collectors.groupingBy(e->e.word,Collectors.mapping(i->i.num,Collectors.toSet())));

    System.out.println(counter);
  }
}