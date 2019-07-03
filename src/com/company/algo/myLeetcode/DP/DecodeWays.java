package com.company.algo.myLeetcode.DP;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 20:45 2018/8/23
 */
/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * */
public class DecodeWays {
    public static int numDecodings(String s) {
        if (s==null || s.length()==0 || s.charAt(0)=='0')
            return 0;
        int m = s.length();
        //f[i]表示s[0..i-1]有几种解码方法
        int[] f = new int[m+1];
        f[0]=1;f[1]=1;
        for (int i=2;i<=m;i++){
            if (s.charAt(i-1)=='0' && (s.charAt(i-2)>'2' || s.charAt(i-2)=='0'))
                return 0;
            if (s.charAt(i-1)=='0')
                f[i]=f[i-2];
            else if (s.charAt(i-2)>'2' || (s.charAt(i-2)=='2' && s.charAt(i-1)>'6') || s.charAt(i-2)=='0')
                f[i] = f[i-1];
            else
                f[i] = f[i-1]+f[i-2];
        }

        return f[m];
    }
    public static void main(String[] args){
        System.out.println(numDecodings("12350"));
    }
}
