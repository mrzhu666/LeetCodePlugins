//In LeetCode Store, there are n items to sell. Each item has a price. However, 
//there are some special offers, and a special offer consists of one or more 
//different kinds of items with a sale price. 
//
// You are given an integer array price where price[i] is the price of the iᵗʰ 
//item, and an integer array needs where needs[i] is the number of pieces of the iᵗ
//ʰ item you want to buy. 
//
// You are also given an array special where special[i] is of size n + 1 where 
//special[i][j] is the number of pieces of the jᵗʰ item in the iᵗʰ offer and 
//special[i][n] (i.e., the last integer in the array) is the price of the iᵗʰ offer. 
//
// Return the lowest price you have to pay for exactly certain items as given, 
//where you could make optimal use of the special offers. You are not allowed to 
//buy more items than you want, even if that would lower the overall price. You 
//could use any of the special offers as many times as you want. 
//
// 
// Example 1: 
//
// 
//Input: price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
//Output: 14
//Explanation: There are two kinds of items, A and B. Their prices are $2 and $5
// respectively. 
//In special offer 1, you can pay $5 for 3A and 0B
//In special offer 2, you can pay $10 for 1A and 2B. 
//You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2)
//, and $4 for 2A.
// 
//
// Example 2: 
//
// 
//Input: price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
//Output: 11
//Explanation: The price of A is $2, and $3 for B, $4 for C. 
//You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C. 
//You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer 
//#1), and $3 for 1B, $4 for 1C. 
//You cannot add more items, though only $9 for 2A ,2B and 1C.
// 
//
// 
// Constraints: 
//
// 
// n == price.length 
// n == needs.length 
// 1 <= n <= 6 
// 0 <= price[i] <= 10 
// 0 <= needs[i] <= 10 
// 1 <= special.length <= 100 
// special[i].length == n + 1 
// 0 <= special[i][j] <= 50 
// 
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 304 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class ShoppingOffers{
  public static void main(String[] args) {
    Solution solution = new ShoppingOffers().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  int n;
  int answer;
  List<Integer> price;
  List<List<Integer>> special;
  public boolean avail(List<Integer> cur,List<Integer> s){
    for(int i=0;i<n;i++)
      if(cur.get(i)<s.get(i)) return false;
    return true;
  }
  public List<Integer> generate(List<Integer> cur,List<Integer> s){
    List<Integer> next=new ArrayList<>();
    for(int i=0;i<n;i++){
      next.add(cur.get(i)-s.get(i));
    }
    return next;
  }
  public int direct(List<Integer> cur){
    int total=0;
    for(int i=0;i<n;i++){
      total+=cur.get(i)*price.get(i);
    }
    return total;
  }

  public void dfs(List<Integer> cur,int index,int curPrice){
    if(curPrice>=answer) return;
    if(index==special.size()){
      curPrice+=direct(cur);
      if(curPrice<answer) answer=curPrice;
      return;
    }
    List<Integer> s=special.get(index);
    if(avail(cur,s)){
      List<Integer> next=generate(cur,s);
      dfs(next,index,curPrice+s.get(n));
    }
    dfs(cur,index+1,curPrice);
  }
  public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

    this.n=needs.size();
    this.price=price;
    this.special=special;
    answer=direct(needs);
    dfs(needs,0,0);
    return answer;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
class Status{
  int[]s;
  int n;
  Status(int[] s){
    this.s=s;
    this.n=s.length;
  }
  /*礼包是否符合*/
  public boolean avail(List<Integer> special){
    for(int i=0;i<n;i++)
      if(s[i]<special.get(i))
        return false;
    return true;
  }
  /*生成下一状态*/
  public Status next(List<Integer> special){
    int[] sNext=new int[n];
    for(int i=0;i<n;i++){
      sNext[i]=s[i]-special.get(i);
    }
    return new Status(sNext);
  }
  /*直接买*/
  public int direct(List<Integer> price){
    int total=0;
    for(int i=0;i<n;i++)
      total+=s[i]*price.get(i);
    return total;
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

  class Status2{
    int[]s;
    int n;
    Status2(int[] s){
      this.s=s;
      this.n=s.length;
    }
    /*礼包是否符合*/
    public boolean avail(List<Integer> special){
      for(int i=0;i<n;i++)
        if(s[i]<special.get(i))
          return false;
      return true;
    }
    /*生成下一状态*/
    public Status next(List<Integer> special){
      int[] sNext=new int[n];
      for(int i=0;i<n;i++){
        sNext[i]=s[i]-special.get(i);
      }
      return new Status(sNext);
    }
    /*直接买*/
    public int direct(List<Integer> price){
      int total=0;
      for(int i=0;i<n;i++)
        total+=s[i]*price.get(i);
      return total;
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

class Solution2 {
  int n;
  int answer;
  List<Integer> price;
  List<List<Integer>> special;
  public void dfs(Status cur,int index,int curPrice){
    if(curPrice==answer) return;
    if(index==special.size()){
      curPrice+=cur.direct(price);
      if(curPrice<answer) answer=curPrice;
      return;
    }
    List<Integer> s=special.get(index);
    if(cur.avail(s)){
      Status next=cur.next(s);
      dfs(next,index,curPrice+ s.get(n));
    }
    dfs(cur,index+1,curPrice);
  }
  public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    this.n=needs.size();
    this.price=price;
    this.special=special;
    int[] s=needs.stream().mapToInt(Integer::valueOf).toArray();
    Status cur=new Status(s);
    answer=cur.direct(price);
    dfs(cur,0,0);
    return answer;
  }
}

  class Status1{
    int[]s;
    int n;
    Status1(int[] s){
      this.s=s;
      this.n=s.length;
    }
    /*礼包是否符合*/
    public boolean avail(List<Integer> special){
      for(int i=0;i<n;i++)
        if(s[i]<special.get(i))
          return false;
      return true;
    }
    /*生成下一状态*/
    public Status next(List<Integer> special){
      int[] sNext=new int[n];
      for(int i=0;i<n;i++){
        sNext[i]=s[i]-special.get(i);
      }
      return new Status(sNext);
    }
    /*直接买*/
    public int direct(List<Integer> price){
      int total=0;
      for(int i=0;i<n;i++)
        total+=s[i]*price.get(i);
      return total;
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

class Solution1 {
  int n;
  List<Integer> price;
  List<List<Integer>> filterSpecial;
  Map<Status,Integer> dp=new HashMap<>();
  int answer=Integer.MAX_VALUE;

  public int dfs(Status cur){
    if(dp.containsKey(cur)){
      System.out.println("dp");
      return dp.get(cur);
    }

    int min=cur.direct(price);
    for(List<Integer> special:filterSpecial){
      if(cur.avail(special)){
        Status next=cur.next(special);
        min=Math.min(min,dfs(next)+special.get(n));
      }
    }
    dp.put(cur,min);
    return min;
  }
  public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    this.n=needs.size();
    this.price=price;
    /*过滤不符合的礼包*/
    this.filterSpecial = new ArrayList<List<Integer>>();
    for (List<Integer> sp : special) {
      int totalCount = 0, totalPrice = 0;
      for (int i = 0; i < n; ++i) {
        totalCount += sp.get(i);
        totalPrice += sp.get(i) * price.get(i);
      }
      if (totalCount > 0 && totalPrice > sp.get(n)) {
        filterSpecial.add(sp);
      }
    }
    int[] s=needs.stream().mapToInt(Integer::valueOf).toArray();
    return dfs(new Status(s));
  }
}
}