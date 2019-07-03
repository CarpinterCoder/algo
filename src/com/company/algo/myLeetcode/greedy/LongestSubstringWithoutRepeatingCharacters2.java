package com.company.algo.myLeetcode.greedy;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 14:08 2018/8/8
 */
/**
 *
 * 不需要返回新的起点处计算，时间复杂度O(n)，推荐！
 */
public class LongestSubstringWithoutRepeatingCharacters2 {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0)return 0;
        if (s.length()==1)return 1;
        int count=0, start=1, len=0;
        //数组元素indexs[ch]表示字符'ch'在s中的索引+1
        int[] indexs = new int[256];
        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (indexs[ch]>=start){
                len = Math.max(len,count);
                count-=indexs[ch]-start+1;
                start = indexs[ch]+1;
            }
            indexs[ch] = i+1;
            count++;
        }
        return Math.max(count,len);
    }
}
