package com.company.algo.myLeetcode.DFS;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 17:53 2018/8/12
 */
/**
 * The n-queens puzzle is the problem of placing n queens on an nn chessboard such that no two queens
 * attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.'
 * both indicate a queen and an empty space respectively.
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * [
 * [".Q..", // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * ["..Q.", // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * */
public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        if (n==0 || n==2){
            return res;
        }
        if (n==1){
            String[] ss = {"Q"};
            res.add(ss);
            return res;
        }

        char[] chs = new char[n];
        for (int i=0;i<n;i++)
            chs[i]='.';
        HashMap<Integer,String> dict = new HashMap<Integer, String>(n);
        for (int i=0;i<n;i++){
            chs[i]='Q';
            dict.put(i,new String(chs));
            chs[i]='.';
        }

        dfs(res,dict,new String[n],0,new int[n]);
        return res;

    }

    private void dfs(ArrayList<String[]> res, HashMap<Integer, String> dict, String[] strs, int row, int[] cols) {
        if (row>=strs.length)
            return;

        for (int i:dict.keySet()){
            boolean flag = true;
            for (int r=0;r<row;r++){
                if (row-r==Math.abs(cols[r]-i))
                    flag = false;
            }

            if (flag){
                String[] strCopy = strs.clone();
                strCopy[row]=dict.get(i);
                if (row==strs.length-1){
                    res.add(strCopy);
                }else {
                    HashMap<Integer,String> tmp = new HashMap<Integer, String>(dict);
                    tmp.remove(i);
                    cols[row]=i;
                    dfs(res,tmp,strCopy,row+1,cols);
                }
            }

        }
    }


}
