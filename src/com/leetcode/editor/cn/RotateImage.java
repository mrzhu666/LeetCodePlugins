//You are given an n x n 2D matrix representing an image, rotate the image by 90
// degrees (clockwise). 
//
// You have to rotate the image in-place, which means you have to modify the 
//input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[7,4,1],[8,5,2],[9,6,3]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 数学 矩阵 👍 1111 👎

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class RotateImage{
  public static void main(String[] args) {
    Solution solution = new RotateImage().new Solution();
//    solution.rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
    System.out.println(Arrays.toString(solution.clockWise(0, 1, 4, false)));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] clockWise(int i,int j,int n,boolean counter){
      /*返回旋转后的坐标*/
      int c=n/2;
      if(n%2==1){
        int x=j-c;
        int y=n-1-i-c;
        int tmp=x;
        if(counter){  // 逆时针
          x=-y;
          y=tmp;
        }else{  // 顺时针
          x=y;
          y=-tmp;
        }
        return new int[]{n-1-c-y,x+c};
      }else{
        // 左下角为原点的坐标
        int x=j;
        int y=n-1-i;
        // 以中心为原点
        if(x<c)
          x-=c;
        else
          x-=c-1;
        if(y<c)
          y-=c;
        else
          y-=c-1;

        int tmp=x;
        if(counter){  // 逆时针
          x=-y;
          y=tmp;
        }else{  // 顺时针
          x=y;
          y=-tmp;
        }
        // 左下角为原点的坐标
        if(x<0)
          x+=c;
        else
          x+=c-1;
        if(y<0)
          y+=c;
        else
          y+=c-1;
        return new int[]{n-1-y,x};
      }

    }
    public void swap(int i,int j,int k,int z,int[][] matrix){
      int v=matrix[i][j];
      matrix[i][j]=matrix[k][z];
      matrix[k][z]=v;
    }
    public void rotate(int[][] matrix) {
      int n=matrix.length;
      for(int i=0;i<n/2;i++)
        for(int j=0;j<(float)n/2;j++){
          int[] next=clockWise(i,j,n,false);
          swap(i,j,next[0],next[1],matrix);  // 顺时针交换
          next=clockWise(i,j,n,true);
          swap(i,j,next[0],next[1],matrix);  // 逆时针交换
          int[] last=next;
          next=clockWise(next[0],next[1],n,true);
          swap(last[0],last[1],next[0],next[1],matrix);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}