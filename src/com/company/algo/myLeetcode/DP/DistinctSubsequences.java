package com.company.algo.myLeetcode.DP;


/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 21:38 2018/8/23
 */
/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can
 * be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is
 * a subsequence of "ABCDE" while "AEC" is not).
 * */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if(T==null || T.length()==0)
            return 1;

        if (S==null || S.length()<T.length())
            return 0;

        //f[j]表示当前时刻(取到S第i个元素时刻)T[j..end]
        int[] f = new int[T.length()];
        for (int i=S.length()-1;i>=0;i--){
            char ch = S.charAt(i);
            int start = 0;
            int index = T.indexOf(ch,start);
            while (index!=-1){
                if (index==T.length()-1){
                    f[index]+=1;
                    break;
                }else {
                    f[index]+=f[index+1];
                }
                start = index+1;
                index = T.indexOf(ch,start);
            }
        }
        return f[0];
    }
}
