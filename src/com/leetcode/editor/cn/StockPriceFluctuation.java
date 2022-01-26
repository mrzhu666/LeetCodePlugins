package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class StockPriceFluctuation {
    public static void main (String[] args){
         StockPrice obj = new StockPriceFluctuation().new StockPrice();
         obj.update(0,1);
         int param_2 = obj.current();
         int param_3 = obj.maximum();
         int param_4 = obj.minimum();
    }

    class StockPrice {
        int cur;
        // 时间：价格
        HashMap<Integer,Integer> timePrice;
        // 价格：时间数量
        TreeMap<Integer,Integer> priceTNum;
        public StockPrice() {
            cur=0;
            timePrice =new HashMap<>();
            priceTNum =new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            cur=Math.max(timestamp,cur);
            // 时间戳之前已出现过
            if(timePrice.containsKey(timestamp)) {
                int oldPrice = timePrice.get(timestamp);
                int num = priceTNum.get(oldPrice);
                if (num > 1)
                    priceTNum.put(oldPrice, num - 1);
                else if(num==1)
                    priceTNum.remove(oldPrice);
            }
            priceTNum.putIfAbsent(price,0);
            timePrice.put(timestamp,price);
            priceTNum.put(price, priceTNum.get(price)+1);
        }

        public int current() {
            return timePrice.get(cur);
        }

        public int maximum() {
            return priceTNum.lastKey();
        }

        public int minimum() {
            return priceTNum.firstKey();
        }
    }
    
}
