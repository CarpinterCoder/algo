package com.company.algo.myLeetcode.DFS;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 17:36 2018/8/13
 */
/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 * */
public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if (n==0)
            return res;
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        HashMap<Integer,String> map = new HashMap<Integer, String>(n+1);
        map.put(0,"");
        for (int i=1;i<=n;i++){
            left.append("(");
            right.append(")");
            map.put(i,right.toString());
        }
        dfs(res,left,map,n,n);
        return res;
    }

    private void dfs(ArrayList<String> res, StringBuilder left, HashMap<Integer, String> map,int position, int remain) {
        if (remain==0 || position==0){
            res.add(left.toString());
            return;
        }

        int max = Math.min(position,remain);
        int min = position==remain?1:0;
        for (int i=max;i>=min;i--){
            StringBuilder copy = new StringBuilder(left);
            copy.insert(position,map.get(i));
            dfs(res,copy,map,position-1,remain-i);
        }
    }

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder("(((((");
        sb.insert(5,")))))");
        System.out.println(sb.toString());
    }
}
