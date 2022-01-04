import java.util.*;
import java.lang.*;

public class FormatInput {
  public static void main(String[] args) {
    String str="[[1,3],[2,6],[8,10],[15,18]]";
    str=str.replace("[","{");
    str=str.replace("]","}");
    str=str.replace("\"","\'");
    System.out.println(str);
  }
}