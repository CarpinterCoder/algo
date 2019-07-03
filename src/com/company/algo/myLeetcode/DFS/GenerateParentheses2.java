package com.company.algo.myLeetcode.DFS;

import java.util.ArrayList;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 20:58 2018/8/13
 */
/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 * */
public class GenerateParentheses2 {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if (n<=0)
            return res;
        StringBuilder str = new StringBuilder("(");
        int left=1,right=0;
        dfs(res,str,left,right,n);
        return res;
    }

    private void dfs(ArrayList<String> res, StringBuilder str, int left, int right, int n) {
        if (right==n){
            res.add(str.toString());
            return;
        }

        if (left<n){
            StringBuilder c1 = new StringBuilder(str);
            c1.append("(");
            dfs(res,c1,left+1,right,n);
        }

        if (right<left){
            StringBuilder c2 = new StringBuilder(str);
            c2.append(")");
            dfs(res,c2,left,right+1,n);
        }
    }
}
