import java.util.*;
import java.lang.*;

public class BinarySearch {
  public static boolean predicate(int num){
    if(num<10)
      return true;
    else
      return false;
  }
  public static void main(String[] args) {
    int mid,left=0,right=100;
    while(right-left>1){
      mid=(left+right)/2;
      if(predicate(mid))
        left=mid;
      else
        right=mid;
    }
    System.out.println(left);
    System.out.println(""+left+right);
  }
}