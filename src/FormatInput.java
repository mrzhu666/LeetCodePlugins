import java.util.*;
import java.lang.*;

public class FormatInput {
  public static void main(String[] args) {
    String str="[[\"0\",\"0\",\"0\",\"1\"],[\"1\",\"1\",\"0\",\"1\"],[\"1\",\"1\",\"1\",\"1\"],[\"0\",\"1\",\"1\",\"1\"],[\"0\",\"1\",\"1\",\"1\"]]";
    str=str.replace("[","{");
    str=str.replace("]","}");
    str=str.replace("\"","\'");
    System.out.println(str);
  }
}