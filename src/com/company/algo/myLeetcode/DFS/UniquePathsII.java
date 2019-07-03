package com.company.algo.myLeetcode.DFS;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 17:20 2018/8/12
 */
/**
 * Follow up for ”Unique Paths”:
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3  3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null || obstacleGrid.length==0 ||
                obstacleGrid[0]==null || obstacleGrid[0].length==0)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m-1][n-1]==1)
            return 0;

        int[][] paths = new int[m][n];

        paths[m-1][n-1]=1;
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                if (obstacleGrid[i][j]!=1){
                    if (i+1<=m-1)
                        paths[i][j]+=paths[i+1][j];
                    if (j+1<=n-1)
                        paths[i][j]+=paths[i][j+1];
                }
            }
        }

        return paths[0][0];
    }
}
