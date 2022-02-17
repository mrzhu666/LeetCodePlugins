package com.leetcode.editor.cn;

//Given an m x n matrix of distinct numbers, return all lucky numbers in the 
//matrix in any order. 
//
// A lucky number is an element of the matrix such that it is the minimum 
//element in its row and maximum in its column. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
//Output: [15]
//Explanation: 15 is the only lucky number since it is the minimum in its row 
//and the maximum in its column.
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
//Output: [12]
//Explanation: 12 is the only lucky number since it is the minimum in its row 
//and the maximum in its column.
// 
//
// Example 3: 
//
// 
//Input: matrix = [[7,8],[1,2]]
//Output: [7]
//Explanation: 7 is the only lucky number since it is the minimum in its row 
//and the maximum in its column.
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= n, m <= 50 
// 1 <= matrix[i][j] <= 10⁵. 
// All elements in the matrix are distinct. 
// 
// Related Topics 数组 矩阵 👍 78 👎 0


import java.util.*;
import java.lang.*;

public class LuckyNumbersInAMatrix {
    public static void main (String[] args){
        Solution solution = new LuckyNumbersInAMatrix().new Solution();
        System.out.println(solution);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int n=matrix.length,m=matrix[0].length;
        int[] rowMin=new int[n];
        int[] colMax=new int[m];
        Arrays.fill(rowMin,Integer.MAX_VALUE);
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                rowMin[i]=Math.min(rowMin[i],matrix[i][j]);
        
        for(int j=0;j<m;j++)
            for(int i=0;i<n;i++)
                colMax[j]=Math.max(colMax[j],matrix[i][j]);
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(rowMin[i]==colMax[j])
                    ans.add(rowMin[i]);
        
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}

