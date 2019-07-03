package com.company.algo.myLeetcode.DP;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 9:31 2018/8/12
 */
/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings
 * recursively.
 * Below is one possible representation of s1 = "great":
 * great
 * / \
 * gr eat
 * / \ / \
 * g r e at
 * / \
 * a t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string
 * "rgeat".
 * rgeat
 * / \
 * rg eat
 * / \ / \
 * r g e at
 * / \
 * a t
 * We say that "rgeat" is a scrambled string of "great".
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string
 * "rgtae".
 * rgtae
 * / \
 * rg tae
 * / \ / \
 * r g ta e
 * / \
 * t a
 * We say that "rgtae" is a scrambled string of "great".
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1==null && s2==null)
            return true;
        if (s1==null || s2==null)
            return false;
        if (s1.length()==0 && s2.length()==0)
            return true;
        if (s1.length()!=s2.length())
            return false;

        int n = s1.length();
        //f[n][i][j]:表示长度为n+1起点分别为i与j的字符串是否匹配
        boolean[][][] f = new boolean[n][n][n];

        for (int x=0;x<n;x++){
            for (int y=0;y<n;y++){
                if (s1.charAt(x)==s2.charAt(y))
                    f[0][x][y]=true;
            }
        }

        for (int z=1;z<n;z++){
            for (int x=0;x<=n-z-1;x++){
                for (int y=0;y<=n-z-1;y++){
                    for (int k=0;k<=z-1;k++){
                        f[z][x][y]=(f[k][x][y] && f[z-k-1][x+k+1][y+k+1]) ||
                                (f[k][x][y+z-k] && f[z-k-1][x+k+1][y]);
                        if (f[z][x][y])
                            break;
                    }
                }
            }

        }

        return f[n-1][0][0];
    }
}
