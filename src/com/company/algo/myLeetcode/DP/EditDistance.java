package com.company.algo.myLeetcode.DP;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 13:39 2018/8/23
 */
/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to
 * word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * • Insert a character
 * • Delete a character
 * • Replace a character
 * */
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        if ((word1==null || word1.length()==0)
                && (word2==null || word2.length()==0))
            return 0;

        if (word1==null || word1.length()==0)
            return word2.length();

        if (word2==null || word2.length()==0)
            return word1.length();

        int m=word1.length(),n=word2.length();
        //f[i][j]表示word1[0..i-1]到word2[0..j-1]的最小距离
        int[][] f = new int[m+1][n+1];

        for (int i=0;i<=m;i++)
            f[i][0] = i;

        for (int j=0;j<=n;j++)
            f[0][j] = j;


        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    f[i][j] = f[i-1][j-1];
                }else {
                    f[i][j] = 1+Math.min(Math.min(f[i-1][j],f[i][j-1]),f[i-1][j-1]);
                }
            }
        }

        return f[m][n];

    }

    public static void main(String[] args){
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(minDistance(word1,word2));
    }
}
