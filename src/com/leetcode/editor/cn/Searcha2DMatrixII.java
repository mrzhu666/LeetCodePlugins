package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class Searcha2DMatrixII {
    public static void main(String[] args) {
        Solution solution = new Searcha2DMatrixII().new Solution();
        System.out.println(solution);
    }

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length, m = matrix[0].length;
            int index = Arrays.binarySearch(matrix[0], target);
            if(index>=0) return true;
            index=-index-1;
            if(index==m) index--;
            for(int i=1;i<n;i++){
                for(;index>=0 && index<m && matrix[i][index]>target;index--);
                if(index>=0 && index<m && matrix[i][index]==target)
                    return true;
                if(index<m-1)
                    index++;
            }
            return false;
        }
    }

}
