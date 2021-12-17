//You are given an array points, an integer angle, and your location, where 
//location = [posx, posy] and points[i] = [xi, yi] both denote integral coordinates 
//on the X-Y plane. 
//
// Initially, you are facing directly east from your position. You cannot move 
//from your position, but you can rotate. In other words, posx and posy cannot be 
//changed. Your field of view in degrees is represented by angle, determining how 
//wide you can see from any given view direction. Let d be the amount in degrees 
//that you rotate counterclockwise. Then, your field of view is the inclusive range 
//of angles [d - angle/2, d + angle/2]. 
//
// 
// Your browser does not support the video tag or this video format. 
// 
//
// You can see some set of points if, for each point, the angle formed by the 
//point, your position, and the immediate east direction from your position is in 
//your field of view. 
//
// There can be multiple points at one coordinate. There may be points at your 
//location, and you can always see these points regardless of your rotation. 
//Points do not obstruct your vision to other points. 
//
// Return the maximum number of points you can see. 
//
// 
// Example 1: 
//
// 
//Input: points = [[2,1],[2,2],[3,3]], angle = 90, location = [1,1]
//Output: 3
//Explanation: The shaded region represents your field of view. All points can 
//be made visible in your field of view, including [3,3] even though [2,2] is in 
//front and in the same line of sight.
// 
//
// Example 2: 
//
// 
//Input: points = [[2,1],[2,2],[3,4],[1,1]], angle = 90, location = [1,1]
//Output: 4
//Explanation: All points can be made visible in your field of view, including 
//the one at your location.
// 
//
// Example 3: 
//
// 
//Input: points = [[1,0],[2,1]], angle = 13, location = [1,1]
//Output: 1
//Explanation: You can only see one of the two points, as shown above.
// 
//
// 
// Constraints: 
//
// 
// 1 <= points.length <= 10⁵ 
// points[i].length == 2 
// location.length == 2 
// 0 <= angle < 360 
// 0 <= posx, posy, xi, yi <= 100 
// 
// Related Topics 几何 数组 数学 排序 滑动窗口 👍 75 👎 0

package com.leetcode.editor.cn;

import java.net.Inet4Address;
import java.util.*;
import java.lang.*;

public class MaximumNumberOfVisiblePoints{
  public static void main(String[] args) {
    Solution solution = new MaximumNumberOfVisiblePoints().new Solution();
    System.out.print(solution);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> location;
    /*到x轴顺时针弧度 [0,360]*/
    public double cangle(List<Integer> o){
      int x=o.get(0)-this.location.get(0);
      int y=o.get(1)-this.location.get(1);
      double d=Math.sqrt(x*x+y*y);
      if(y>=0) return Math.acos(x/d);
      else return 2*Math.PI-Math.acos(x/d);
    }
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
      this.location=location;

      int add=0;
      List<Double> rad=new ArrayList<>();
      for(List<Integer> p:points){
        if(p.equals(location))
          add++;
        else
          rad.add(cangle(p));
      }
      Collections.sort(rad);

      int answer=1;
      int l=-1,r=1;
      int n=rad.size();
//      System.out.println(points);
//      System.out.println(n);
//      System.out.println(Math.abs(cangle(points.get(3))- cangle(points.get(1)))<=angle+10E-16);
      System.out.println(rad);
      while(l!=n-1){
        l++;
        if(l==r)r=(r+1)%n;
        while(l!=r && Math.abs(rad.get(r)-rad.get(l))<=angle*Math.PI/180){
          r=(r+1)%n;
        }
        if(l==r)return n+add;
        System.out.format("%d %d \n",l,r);
        answer=Math.max(answer,(r-l+n)%n);
      }
      return answer+add;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  /*
  1.反三角函数精度问题 abs(angle-angle)<=0
  2.在原整数元素组排序 用的有问题
  * */
class Solution1 {
    List<Integer> location;
    /*到x轴顺时针角度 [0,360]*/
    public double cangle(List<Integer> o){
      int x=o.get(0)-this.location.get(0);
      int y=o.get(1)-this.location.get(1);
      double d=Math.sqrt(x*x+y*y);
      if(y>=0) return Math.acos(x/d)*180/Math.PI;
      else return (2*Math.PI-Math.acos(x/d))*180/Math.PI;
    }
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
      this.location=location;
      points.sort(new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
          if(o1.equals(location)) return -1;
          if(o2.equals(location)) return 1;
          return (int)(cangle(o1)- cangle(o2)); // 精度有问题
        }
      });
      int add=0;
      while(points.get(0).equals(location)){
        points.remove(0);
        add++;
      }

      int answer=1;
      int l=-1,r=1;
      int n=points.size();
      System.out.println(points);
      System.out.println(n);
//      System.out.println(Math.abs(cangle(points.get(3))- cangle(points.get(1)))<=angle+10E-16);

      while(l!=n-1){
        l++;
        if(l==r)r=(r+1)%n;
        while(l!=r && Math.abs(cangle(points.get(r))- cangle(points.get(l)))<=angle+100){
          r=(r+1)%n;
        }
        if(l==r)return n+add;
        System.out.format("%d %d \n",l,r);
        answer=Math.max(answer,(r-l+n)%n);
      }
      return answer+add;
    }
}

}