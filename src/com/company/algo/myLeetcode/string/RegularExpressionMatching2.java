package com.company.algo.myLeetcode.string;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 23:46 2018/7/5
 */
/* Implement regular expression matching with support for '.'
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
/* 动态规划：时间复杂度是O(m*n),空间复杂度是O(m*n)
 * 假设我们维护一个布尔数组res[i][j],代表s的前i个字符和p的前j个字符是否匹配(注意这里res的维度是s.length()+1,p.length()+1)，而s[i]、p[j]的索引是从0开始的。
 * 递推公式分三种种情况：
 * (1)p[j]不是'*'。情况比较简单，当(s[i]==p[j] || p[j]==".")有res[i+1][j+1]=res[i][j]
 * (2)p[j]是'*'，但是p[j-1]!='.'。那么只要以下条件有一个满足即可对res[i+1][j+1]赋值为true：
 *  1)res[i+1][j-1]为真(s[0..i]与p[0..j-2]匹配)（'*'前面字符一次都不取，也就是忽略这两个字符）;
 *  2)res[i+1][j](s[0..i]与p[0..j-1]匹配)为真（'*'只取前面字符一次）;
 *  3)res[i][j+1] && s[i]==s[i-1] && s[i-1]==p[j-1](这种情况是相当于i从0到s.length()扫过来，
 * 如果p[j+1]对应的字符是‘*’那就意味着接下来的串就可以依次匹配下来，如果下面的字符一直重复，并且就是‘*’前面的那个字符）。
 * (3)p[j]是'*'，并且p[j-1]=='.'。因为".*"可以匹配任意字符串，所以在前面的res[i+1][j-1]或者res[i+1][j]中只要有i+1是true，
 * 那么剩下的res[i+1][j+1],res[i+2][j+1],...,res[s.length()][j+1]就都是true了。
 */
public class RegularExpressionMatching2 {
    public static boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0)
            return true;
        if (p.length() == 0)
            return false;
        boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
        res[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                if (j > 0 && res[0][j - 1])
                    res[0][j + 1] = true;
                if (j < 1){
                    if (s.charAt(0)=='*')
                        res[1][1] = true;
                    continue;
                }
                if (p.charAt(j - 1) != '.') {
                    for (int i = 0; i < s.length(); i++) {
                        if (res[i + 1][j] || j > 0 && res[i + 1][j - 1] || i > 0 && j > 0 && res[i][j + 1]
                                && s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == p.charAt(j - 1))
                            res[i + 1][j + 1] = true;
                    }
                } else {
                    int i = 0;
                    while (j > 0 && i < s.length() && !res[i + 1][j - 1] && !res[i + 1][j])
                        i++;
                    for (; i < s.length(); i++) {
                        res[i + 1][j + 1] = true;
                    }
                }
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
                        res[i + 1][j + 1] = res[i][j];
                }
            }
        }
        return res[s.length()][p.length()];
    }
    public static void main(String[] args){
        System.out.println(isMatch("a","*"));
    }
}
