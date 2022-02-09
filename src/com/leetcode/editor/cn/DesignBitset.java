package com.leetcode.editor.cn;

//A Bitset is a data structure that compactly stores bits. 
//
// Implement the Bitset class: 
//
// 
// Bitset(int size) Initializes the Bitset with size bits, all of which are 0. 
// void fix(int idx) Updates the value of the bit at the index idx to 1. If the 
//value was already 1, no change occurs. 
// void unfix(int idx) Updates the value of the bit at the index idx to 0. If 
//the value was already 0, no change occurs. 
// void flip() Flips the values of each bit in the Bitset. In other words, all 
//bits with value 0 will now have value 1 and vice versa. 
// boolean all() Checks if the value of each bit in the Bitset is 1. Returns 
//true if it satisfies the condition, false otherwise. 
// boolean one() Checks if there is at least one bit in the Bitset with value 1.
// Returns true if it satisfies the condition, false otherwise. 
// int count() Returns the total number of bits in the Bitset which have value 1
//. 
// String toString() Returns the current composition of the Bitset. Note that 
//in the resultant string, the character at the iᵗʰ index should coincide with the 
//value at the iᵗʰ bit of the Bitset. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Bitset", "fix", "fix", "flip", "all", "unfix", "flip", "one", "unfix", 
//"count", "toString"]
//[[5], [3], [1], [], [], [0], [], [], [0], [], []]
//Output
//[null, null, null, null, false, null, null, true, null, 2, "01010"]
//
//Explanation
//Bitset bs = new Bitset(5); // bitset = "00000".
//bs.fix(3);     // the value at idx = 3 is updated to 1, so bitset = "00010".
//bs.fix(1);     // the value at idx = 1 is updated to 1, so bitset = "01010". 
//bs.flip();     // the value of each bit is flipped, so bitset = "10101". 
//bs.all();      // return False, as not all values of the bitset are 1.
//bs.unfix(0);   // the value at idx = 0 is updated to 0, so bitset = "00101".
//bs.flip();     // the value of each bit is flipped, so bitset = "11010". 
//bs.one();      // return True, as there is at least 1 index with value 1.
//bs.unfix(0);   // the value at idx = 0 is updated to 0, so bitset = "01010".
//bs.count();    // return 2, as there are 2 bits with value 1.
//bs.toString(); // return "01010", which is the composition of bitset.
// 
//
// 
// Constraints: 
//
// 
// 1 <= size <= 10⁵ 
// 0 <= idx <= size - 1 
// At most 10⁵ calls will be made in total to fix, unfix, flip, all, one, count,
// and toString. 
// At least one call will be made to all, one, count, or toString. 
// At most 5 calls will be made to toString. 
// 
// 👍 11 👎 0

import java.util.*;
import java.lang.*;

public class DesignBitset {
    public static void main (String[] args){
        Bitset solution = new DesignBitset().new Bitset(1);
        System.out.println(solution);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Bitset {
    int[] bits;
    int f;
    int size;
    int countOne;
    
    public Bitset(int size) {
        this.bits=new int[size];
        this.f=0;
        this.size=size;
        this.countOne=0;
    }
    
    public void fix(int idx) {
        if((bits[idx]+f)%2==0){
            bits[idx]++;
            countOne++;
        }
    }
    
    public void unfix(int idx) {
        if((bits[idx]+f)%2==1){
            bits[idx]++;
            countOne--;
        }
    }
    
    public void flip() {
        countOne=size-countOne;
        f++;
    }
    
    public boolean all() {
        return countOne==size;
    }
    
    public boolean one() {
        return countOne>0;
    }
    
    public int count() {
        return countOne;
    }
    
    public String toString() {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<size;i++){
            if((bits[i]+f)%2==0)
                str.append(0);
            else
                str.append(1);
        }
        return str.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
//leetcode submit region end(Prohibit modification and deletion)

    
}

