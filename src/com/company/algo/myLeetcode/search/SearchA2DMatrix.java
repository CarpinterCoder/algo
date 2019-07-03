package com.company.algo.myLeetcode.search;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 20:51 2018/7/24
 */
/**
 * Write an efficient algorithm that searches for a value in an mn matrix.
 * This matrix has the following
 * properties:
 *         • Integers in each row are sorted from left to right.
 *         • The first integer of each row is greater than the last integer of the previous row.
 *      For example, Consider the following matrix:
 *         [
 *           [1, 3, 5, 7],
 *           [10, 11, 16, 20],
 *           [23, 30, 34, 50]
 *         ]
 *           Given target = 3, return true.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0)return false;
        int M = matrix.length;
        int N = matrix[0].length;
        int lo = 0;
        int hi = M-1;
        int mid = 0;
        while (lo<=hi){
            mid = (lo+hi)/2;
            if (matrix[mid][N-1]<target)
                lo = mid+1;
            else if (matrix[mid][N-1]>target)
                hi = mid-1;
            else
                return true;
        }

        mid = lo;
        lo = 0;
        hi = N-1;
        if (mid>=0 && mid<M){
            while (lo<=hi){
                int mid2 = (lo+hi)/2;
                if (matrix[mid][mid2]>target)
                    hi = mid2-1;
                else if (matrix[mid][mid2]<target)
                    lo = mid2 + 1;
                else
                    return true;
            }
        }
        return false;
    }
}
