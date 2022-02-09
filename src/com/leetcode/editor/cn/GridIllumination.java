package com.leetcode.editor.cn;

//There is a 2D grid of size n x n where each cell of this grid has a lamp that 
//is initially turned off. 
//
// You are given a 2D array of lamp positions lamps, where lamps[i] = [rowi, 
//coli] indicates that the lamp at grid[rowi][coli] is turned on. Even if the same 
//lamp is listed more than once, it is turned on. 
//
// When a lamp is turned on, it illuminates its cell and all other cells in the 
//same row, column, or diagonal. 
//
// You are also given another 2D array queries, where queries[j] = [rowj, colj].
// For the jᵗʰ query, determine whether grid[rowj][colj] is illuminated or not. 
//After answering the jᵗʰ query, turn off the lamp at grid[rowj][colj] and its 8 
//adjacent lamps if they exist. A lamp is adjacent if its cell shares either a side 
//or corner with grid[rowj][colj]. 
//
// Return an array of integers ans, where ans[j] should be 1 if the cell in the 
//jᵗʰ query was illuminated, or 0 if the lamp was not. 
//
// 
// Example 1: 
//
// 
//Input: n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
//Output: [1,0]
//Explanation: We have the initial grid with all lamps turned off. In the above 
//picture we see the grid after turning on the lamp at grid[0][0] then turning on 
//the lamp at grid[4][4].
//The 0ᵗʰ query asks if the lamp at grid[1][1] is illuminated or not (the blue 
//square). It is illuminated, so set ans[0] = 1. Then, we turn off all lamps in 
//the red square.
//
//The 1ˢᵗ query asks if the lamp at grid[1][0] is illuminated or not (the blue 
//square). It is not illuminated, so set ans[1] = 0. Then, we turn off all lamps 
//in the red rectangle.
//
// 
//
// Example 2: 
//
// 
//Input: n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
//Output: [1,1]
// 
//
// Example 3: 
//
// 
//Input: n = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
//Output: [1,1,0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁹ 
// 0 <= lamps.length <= 20000 
// 0 <= queries.length <= 20000 
// lamps[i].length == 2 
// 0 <= rowi, coli < n 
// queries[j].length == 2 
// 0 <= rowj, colj < n 
// 
// Related Topics 数组 哈希表 👍 90 👎 0


import java.util.*;
import java.lang.*;

public class GridIllumination {
    public static void main(String[] args) {
        Solution solution = new GridIllumination().new Solution();
        System.out.println(Arrays.toString(solution.gridIllumination(5, new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {1, 0}})));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer,HashSet<Integer>> xHash;
        HashMap<Integer,HashSet<Integer>> yHash;
        HashMap<Integer,HashSet<Integer>> diagonal;
        HashMap<Integer,HashSet<Integer>> diagonalDeputy;
        int n;
        int[][] actions=new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        // [0] y,[1] x
        public boolean search(int x,int y){
            int dia=x+y;
            int diaDe=y-x;
            if(xHash.containsKey(x))
                return true;
            if(yHash.containsKey(y))
                return true;
            if(diagonal.containsKey(dia))
                return true;
            if(diagonalDeputy.containsKey(diaDe))
                return true;
            return false;
        }
        
        public void empty(int key,int value,HashMap<Integer,HashSet<Integer>> target){
            HashSet<Integer> tmp=target.get(key);
            if(tmp!=null){
                tmp.remove(value);
                if(tmp.isEmpty())
                    target.remove(key);
            }
        }
        
        public void delete(int x,int y){
            if(x<0 || x>n-1 || y<0 || y>n-1)
                return;
//            if(!xHash.containsKey(x) || !xHash.get(x).contains(y))
//                return;
            
            int dia=x+y;
            int diaDe=y-x;
            
            empty(x,y,xHash);
            empty(y,x,yHash);
            empty(dia,y,diagonal);
            empty(diaDe,y,diagonalDeputy);
            
        }
        
        public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
            xHash=new HashMap<>();
            yHash=new HashMap<>();
            diagonal=new HashMap<>();
            diagonalDeputy=new HashMap<>();
            this.n=n;
            int m=queries.length;
            int[] ans=new int[m];
            for(int[] v:lamps){
                int y=v[0];int x=v[1];
                int dia=x+y;
                int diaDe=y-x;
                xHash.computeIfAbsent(x,o1->new HashSet<>());
                yHash.computeIfAbsent(y,o1->new HashSet<>());
                diagonal.computeIfAbsent(dia,o1->new HashSet<>());
                diagonalDeputy.computeIfAbsent(diaDe,o1->new HashSet<>());
                xHash.get(x).add(y);
                yHash.get(y).add(x);
                diagonal.get(dia).add(y);
                diagonalDeputy.get(diaDe).add(y);
            }
            
            for(int i=0;i<m;i++){
                int[] q=queries[i];
                int y=q[0];int x=q[1];
                if(search(x,y)){
                    delete(x,y);
                    for(int[] action:actions){
                        delete(x+action[0],y+action[1]);
                    }
                    ans[i]=1;
                }else{
                    ans[i]=0;
                }
            }
            
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}

