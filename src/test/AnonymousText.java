package test;

import java.util.*;
import java.lang.*;


class parent{

}

public class AnonymousText {
  public static void main(String[] args) {
    parent p=new parent(){
      public void method(){
        System.out.println("add method");
      }
    };
//    p.method();
  }
}