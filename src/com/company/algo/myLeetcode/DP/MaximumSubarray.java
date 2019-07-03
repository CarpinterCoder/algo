package com.company.algo.myLeetcode.DP;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 16:55 2018/8/8
 */
/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has
 * the largest sum = 6.
 *
 * */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        if (A==null || A.length==0)
            return 0;
        if (A.length==1)
            return A[0];

        //数组元素f[i]表示以A[i]为最后一个元素的最大连续元素之和
        int[] f = new int[A.length];
        f[0] = A[0];
        int max = A[0];
        for (int i=1;i<f.length;i++){
            f[i] = Math.max(A[i],A[i]+f[i-1]);
            max = Math.max(max,f[i]);
        }

        return max;
    }
}
