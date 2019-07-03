package com.company.algo.myLeetcode.greedy;

import java.util.HashMap;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 10:55 2018/8/8
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s==null)
            return 0;
        if (s.length()<2)
            return s.length();

        int maxLen = 0;
//        int len = 0;
        int start = 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            Integer index = map.put(c,i);//返回旧索引，不存在则返回null
            if (index!=null){
                maxLen = Math.max(i-start,maxLen);
                start = index+1;
                map.clear();
                i = start-1;
            }
            if (i==s.length()-1)
                maxLen = Math.max(maxLen,i-start+1);
        }

        return maxLen;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcdefgalmnopqegxyz"));
    }
}
