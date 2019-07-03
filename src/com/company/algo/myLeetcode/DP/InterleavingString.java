package com.company.algo.myLeetcode.DP;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 21:07 2018/8/11
 */
/**
 * Given s1; s2; s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1==null && s2==null && s3==null ||
                s1.length()==0 && s2.length()==0 && s3.length()==0)
            return true;
        if (s1==null && s2==null || s1.length()==0 && s2.length()==0)
            return false;

        if (s1==null || s1.length()==0)
            return s2.equals(s3);

        if (s2==null || s2.length()==0)
            return s1.equals(s3);

        int m = s1.trim().length();
        char[] chs1 = (" "+s1.trim()).toCharArray();
        int n = s2.trim().length();
        char[] chs2 = (" "+s2.trim()).toCharArray();
        int l = s3.trim().length();
        char[] chs3 = (" "+s3.trim()).toCharArray();
        if (m+n!=l)
            return false;
        //f[i][j]表示s1[0..i-1]、s2[0..j-1]与s3[0..i+j-1]是否匹配
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for (int s=1;s<l+1;s++){
            int sum = s-1;
            for (int i=0;i<=m;i++){
                int j = sum-i;
                if (j>=0 && j<=n && f[i][j]){
                    if (i+1<=m && chs1[i+1]==chs3[s]){
                        f[i+1][j]=true;
                        if (s==l)
                            return true;
                    }
                    if (j+1<=n && chs2[j+1]==chs3[s]){
                        f[i][j+1]=true;
                        if (s==l)
                            return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        String s = " abc";
        char[] chs = s.toCharArray();
        for (int i=0;i<chs.length;i++)
            System.out.println(i+":"+chs[i]);
    }
}
