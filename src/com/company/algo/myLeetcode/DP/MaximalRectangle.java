package com.company.algo.myLeetcode.DP;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 21:51 2018/8/8
 */

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return
 * its area.
 * */
public class MaximalRectangle {
    public int maximalRectangle(boolean[][] matrix) {
        // write your code here
        if (matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0)
            return 0;

        int res = 0;
        int[] histogram = new int[matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]){
                    histogram[j]++;
                }else {
                    histogram[j] = 0;
                }
            }
            res = Math.max(res,largestRectangleArea(histogram));

        }
        return res;
    }

    private int largestRectangleArea(int[] histogram) {
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0;i<histogram.length;){
            if (stack.isEmpty() || histogram[i]>=histogram[stack.peek()]){
                stack.push(i);
                i++;
            }else {
                int index = stack.pop();
                if (!stack.isEmpty()) {
                    res = Math.max(res, histogram[index] * (i - 1 - stack.peek()));
                }else {
                    res = Math.max(res,histogram[index]*i);
                }
            }
        }

        while (!stack.isEmpty()){
            int index = stack.pop();
            if (!stack.isEmpty()) {
                res = Math.max(res, histogram[index] * (histogram.length - index));
            }else {
                res = Math.max(res,histogram[index]*histogram.length);
            }
        }


        return res;
    }
}
