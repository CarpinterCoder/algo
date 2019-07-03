package com.company.algo.myLeetcode.DP;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 13:54 2018/8/24
 */
/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * */
public class WordBreak {
    public static boolean wordBreak(String s, Set<String> dict) {
        if (s==null || s.length()==0)
            return false;

        if (dict.contains(s))
            return true;
        //queue中的数字i表示s[i+1..end]子串能够切分为独立的单词
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(s.length()-1);
        while (!queue.isEmpty()){
            int i = queue.poll();
            for (int j=i;j>=0;j--){
                if (dict.contains(s.substring(j,i+1))){
                    if (j==0)
                        return true;
                    queue.offer(j-1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        String s = "cattsandog";
        Set<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("san");
        dict.add("tsan");
        dict.add("dog");
        System.out.println(wordBreak(s,dict));
    }
}
