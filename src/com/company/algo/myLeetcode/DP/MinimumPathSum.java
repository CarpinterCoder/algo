package com.company.algo.myLeetcode.DP;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 11:06 2018/8/23
 */
/**
 * Given a m  n grid filled with non-negative numbers, find a path from top left to bottom right which
 * minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time
 * */
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid==null || grid.length==0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        //miniSum[i][j]表示由[i][j]到达[m-1][n-1]的最小路径和
        int[][] miniSum = new int[m][n];
        miniSum[m-1][n-1]=grid[m-1][n-1];
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                if (i==m-1 && j==n-1)
                    continue;
                int down=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
                if (i+1<=m-1)
                    down = miniSum[i+1][j];
                if (j+1<=n-1)
                    right = miniSum[i][j+1];

                miniSum[i][j] = grid[i][j]+Math.min(down,right);
            }
        }

        return miniSum[0][0];
    }

    public static void main(String[] args){
        int[][] grid = {{1,2},{1,1}};
        System.out.println(minPathSum(grid));
    }
}
