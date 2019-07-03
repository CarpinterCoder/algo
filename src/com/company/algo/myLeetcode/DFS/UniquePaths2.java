package com.company.algo.myLeetcode.DFS;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 15:26 2018/8/12
 */
/**
 * A robot is located at the top-left corner of a m  n grid (marked ’Start’ in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the
 * bottom-right corner of the grid (marked ’Finish’ in the diagram below).
 * How many possible unique paths are there?
 * 思路：动规
 */
public class UniquePaths2 {
    public int uniquePaths(int m, int n) {
        if (m<=0 || n<=0)
            return 0;
        //paths[i][j]表示由(i+1,j+1)到达(m,n)有几条独立路径
        int[][] paths = new int[m][n];
        paths[m-1][n-1]=1;
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                if (i+1<=m-1)
                    paths[i][j]+=paths[i+1][j];
                if (j+1<=n-1)
                    paths[i][j]+=paths[i][j+1];
            }
        }
        return paths[0][0];
    }
}
