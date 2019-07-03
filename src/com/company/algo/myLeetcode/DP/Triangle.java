package com.company.algo.myLeetcode.DP;

import java.util.ArrayList;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 15:26 2018/8/8
 */
/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent
 * numbers on the row below.
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number of
 * rows in the triangle.
 * */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle==null || triangle.size()==0)
            return 0;
        if (triangle.size()==1)
            return triangle.get(0).get(0);

        //f[i][j]表示从第i行第j列出发的路径最小和
        int[][] f = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for (int j=0;j<triangle.get(triangle.size()-1).size();j++)
            f[triangle.size()-1][j] = triangle.get(triangle.size()-1).get(j);

        for (int r=triangle.size()-2;r>=0;r--){
            for (int c=0;c<triangle.get(r).size();c++){
                f[r][c] = Math.min(f[r+1][c],f[r+1][c+1])+triangle.get(r).get(c);
            }
        }

        return f[0][0];

    }
}
