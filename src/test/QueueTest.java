package test;

import java.util.*;
import java.lang.*;

public class QueueTest {
  public static void main(String[] args) {
    PriorityQueue<Integer> queue=new PriorityQueue<>();
    queue.offer(1);
    queue.offer(2);
    System.out.println(queue);
  }
}