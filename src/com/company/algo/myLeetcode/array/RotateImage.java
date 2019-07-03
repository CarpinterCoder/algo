package com.company.algo.myLeetcode.array;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 22:12 2018/7/30
 */
/**
 * You are given an n  n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up: Could you do this in-place?
 *
 * */
public class RotateImage {
    public void rotate(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        //沿主对角线翻转一次
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //沿垂直中线翻转一次
        for (int i=0;i<n;i++){
            for (int lo=0,hi=n-1;lo<hi;){
                int tmp = matrix[i][lo];
                matrix[i][lo] = matrix[i][hi];
                matrix[i][hi] = tmp;
                lo++;
                hi--;
            }
        }
    }
}
