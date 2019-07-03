package com.company.algo.myLeetcode.DFS;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 21:14 2018/8/12
 */
/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 * */
public class NQueensII {
    public int totalNQueens(int n) {
        if (n==0 || n==2)
            return 0;
        if (n==1)
            return 1;

        Set<Integer> dict = new HashSet<Integer>(n);
        for (int i=1;i<=n;i++)
            dict.add(i);

        int res = dfs(dict,1,new int[n]);

        return res;
    }

    private int dfs(Set<Integer> dict,int row,int[] cols) {
        int res = 0;
        for (int i:dict){
            boolean flag = true;
            for (int r=0;r<row-1;r++){
                if (row-(r+1)==Math.abs(cols[r]-i))
                    flag = false;
            }
            if (flag){
                if (row==cols.length){
                    return 1;
                }else {
                    cols[row-1]=i;
                    Set<Integer> tmp = new HashSet<Integer>(dict);
                    tmp.remove(i);
                    res+=dfs(tmp,row+1,cols);
                }
            }
        }

        return res;
    }
}
