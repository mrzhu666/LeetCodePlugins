package competition;

import java.util.*;
import java.lang.*;

public class DesignBitset {
    public static void main (String[] args){
        Bitset solution = new DesignBitset().new Bitset(10);
        System.out.println(solution);
    }
    
    class Bitset {
        boolean[] bits;
        int size;
        int oneNum;
        int flipNum;
        public Bitset(int size) {
            this.size=size;
            oneNum=0;
            flipNum=0;
            bits=new boolean[size];
        }
        
        public void fix(int idx) {
            if(flipNum!=0)
                flipAll();
            if(!bits[idx])
                oneNum++;
            bits[idx]=true;
        }
        
        public void unfix(int idx) {
            if(flipNum!=0)
                flipAll();
            if(bits[idx])
                oneNum--;
            bits[idx]=false;
        }
        
        public void flipAll(){
            if(flipNum%2==1){
                for(int i=0;i<size;i++){
                    bits[i]=!bits[i];
                }
            }
            flipNum=0;
        }
        
        public void flip() {
            oneNum=size-oneNum;
            flipNum++;
        }
        
        public boolean all() {
            return oneNum==size;
        }
        
        public boolean one() {
            return oneNum>0;
        }
        
        public int count() {
            return oneNum;
        }
        
        public String toString() {
            if(flipNum!=0)
                flipAll();
            StringBuilder str=new StringBuilder();
            for(int i=0;i<size;i++){
                if(bits[i])
                    str.append('1');
                else
                    str.append('0');
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
    
}
