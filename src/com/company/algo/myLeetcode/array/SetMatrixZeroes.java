package com.company.algo.myLeetcode.array;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 11:15 2018/7/31
 */
/**
 * Given a m  n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Follow up: Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 * */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0)return;
        int m = matrix.length, n = matrix[0].length;
        boolean row = false;//第一行标志，若第一行存在0，为true，否则为false
        boolean column = false;//第一列标志，若第一行存在0，为true，否则为false
        //扫描第一行，查看是否有0
        for (int i=0;i<n;i++){
            if (matrix[0][i]==0){
                row = true;
                break;
            }
        }
        //扫描第一列，查看是否有0
        for (int j=0;j<m;j++){
            if (matrix[j][0]==0){
                column = true;
                break;
            }
        }
        //扫描出去第一行与第一列的整个矩阵，若为0，则将第一行与第一列相应位置赋0
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        //再次扫描除第一行与第一列的整个矩阵，若其对应的第一行或第一列上的元素中有一个为0，则将其赋0
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if (matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        //若第一行有0，则将第一行所有元素赋0
        if (row){
            for (int i=0;i<n;i++)
               matrix[0][i]=0;
        }
        //若第一列有0，则将第一列所有元素赋0
        if (column){
            for (int j=0;j<m;j++)
                matrix[j][0]=0;
        }

    }
}
