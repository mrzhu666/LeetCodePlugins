import java.util.*;
import java.lang.*;

public class FormatInput {
  public static void main(String... args) {
    Scanner scanner = new Scanner(System.in);
    String str=scanner.nextLine();
    str=str.replace("[","{");
    str=str.replace("]","}");
    str=str.replace("\"","\'");
    System.out.println(str);
  }
}