package com.company.algo.myLeetcode.DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 19:20 2018/8/24
 */
/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word
 * is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 * */
public class WordBreakII {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<String> strQueue = new LinkedList<String>();
        //queue中的数字i表示s[0..i]子串能够切分为独立的单词
        queue.offer(0);
        strQueue.offer("");
        while (!queue.isEmpty()){
            int i = queue.poll();
            String sub = strQueue.poll();
            for (int j=i;j<s.length();j++){
                if (dict.contains(s.substring(i,j+1))){
                    if (j+1==s.length()){
                        res.add(sub+s.substring(i));
                    }else{
                        queue.offer(j+1);
                        strQueue.offer(sub+s.substring(i,j+1)+" ");
                    }
                }
            }
        }
        return res;
    }
}
