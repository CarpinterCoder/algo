package com.company.algo.myLeetcode.array;

import java.util.HashMap;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 14:47 2018/7/29
 */
/**
 *
 * Question:
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1,
 * 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 *
 *
 * */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num==null || num.length==0)return 0;
        if (num.length==1)return 1;
        HashMap<Integer,Boolean> map = new HashMap<Integer, Boolean>(num.length);
        for (int i=0;i<num.length;i++){
            map.put(num[i],false);
        }
        int max = 0;
        for (Integer n: map.keySet()){
            if (!map.get(n)){
                int len = 1;
                map.put(n,true);
                int k = n;
                while (map.containsKey(--k)){
                    len++;
                    map.put(k,true);
                }
                while (map.containsKey(++n)){
                    len++;
                    map.put(n,true);
                }
                max = Math.max(max,len);
            }
        }

        return max;
    }
}
