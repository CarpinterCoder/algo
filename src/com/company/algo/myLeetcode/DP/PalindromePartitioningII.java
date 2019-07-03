package com.company.algo.myLeetcode.DP;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 17:04 2018/8/8
 */
/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s==null || s.length()<2)
            return 0;
        char[] chars = s.toCharArray();
        int n = s.length();
        //数组元素f[i]表示区间[i,n-1]最少分割次数
        int[] f = new int[n];
        for (int i=0;i<n;i++)
            f[i] = Integer.MAX_VALUE;

        f[n-1] = 0;

        for (int i=n-2;i>=0;i--){
            for (int k=n-1;k>=i;k--){
                //判断[i,k]是否是回文
                int lo = i,hi = k;
                boolean flag = true;
                while (hi>lo){
                    if (chars[hi]!=chars[lo]){
                        flag = false;
                        break;
                    }
                    lo++;
                    hi--;
                }

                if (flag){
                    if (k==n-1){
                        f[i] = f[n-1];
                        break;
                    }
                    else
                        f[i] = Math.min(f[i],1+f[k+1]);
                }
            }
        }
        return f[0];
    }
}
