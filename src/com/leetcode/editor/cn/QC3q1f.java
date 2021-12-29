//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 设计 字典树 哈希表 字符串 👍 8 👎 0

package com.leetcode.editor.cn;

import java.util.*;
import java.lang.*;

public class QC3q1f{
  public static void main(String[] args) {

  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    private Trie[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
      children=new Trie[26];
      isEnd=false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
      Trie node=this;
      for(int i=0;i<word.length();i++){
        char ch=word.charAt(i);
        int index=ch-'a';
        if(node.children[index]==null){
          node.children[index]=new Trie();
        }
        node=node.children[index];
      }
      node.isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      Trie node=searchPrefix(word);
      return node!=null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix){
      Trie node=this;
      for(int i=0;i<prefix.length();i++){
        char ch=prefix.charAt(i);
        int index=ch-'a';
        node=node.children[index];
        if(node==null)
          return null;
      }
      return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}