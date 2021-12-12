package test;

import java.util.*;
import java.lang.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ReconstructOriginalDigitsFromEnglishTest {
  public static void main(String[] args) {
    String[] nums = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};


    Map<Character,Set<Integer>> numCharSetIntOne=new HashMap<Character,Set<Integer>>(){

    };
    List<Integer> filterList=new LinkedList<>(Arrays.asList(8,4,2,6,0));
    IntStream.range(0,10).filter(i->!filterList.contains(i)).forEach(
        i->nums[i].chars().forEach(
            ch->numCharSetIntOne.computeIfAbsent((char)ch,HashSet::new).add(i)));
//    for(int i=0;i<10;i++){
//      int finalI = i;
//      nums[i].chars()
//        .forEach(ch->numCharSetIntOne.computeIfAbsent((char)ch,HashSet::new).add(finalI));
//    }
    System.out.println(numCharSetIntOne);
    /*----------------------------------------------------------------------------------------*/
    Map<Character,Set<Integer>> numCharSetInt=new HashMap<>();
    for(int i=0;i<10;i++){
      for(Character ch:nums[i].toCharArray()){
        Set<Integer> tmp=numCharSetInt.computeIfAbsent(ch, HashSet::new);
        tmp.add(i);
      }
    }
    System.out.println(numCharSetInt);
    /*----------------------------------------------------------------------------------------*/
    String numString=String.join("",nums);
    Map<Character, String> numCharMap=numString
      .chars()
      .distinct()
      .boxed()
      .collect(Collectors.toMap(i->(char)i.intValue(), i->""));

    IntStream.range(0,10)
      .forEach(
        i->nums[i]
          .chars()
          .distinct()
          .forEach(value->numCharMap.put((char)value, numCharMap.get((char)value)+i)));

    System.out.println(numCharMap.toString());
  }
}