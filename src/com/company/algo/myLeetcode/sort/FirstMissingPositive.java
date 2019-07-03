package com.company.algo.myLeetcode.sort;

/**
 * @Description: ***
 * @Author:XiaoNing
 * @Date:Greated in 16:19 2018/7/24
 */
/**
 * Given an unsorted integer array, find the first missing positive integer.
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 *
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if (A==null || A.length==0)return 1;
        for (int i=0;i<A.length;i++){
            int k;
            while ((k=A[i])!=i+1 && k>=1 && k<=A.length && A[k-1]!=A[i]){
                    A[i] = A[k-1];
                    A[k-1] = k;
            }
        }
        for (int i=0;i<A.length;i++){
            if (A[i]!=i+1)
                return i+1;
        }
        return A.length+1;
    }
}
