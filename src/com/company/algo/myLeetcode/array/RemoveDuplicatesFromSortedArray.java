package com.company.algo.myLeetcode.array;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 20:50 2018/7/27
 */
/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once
 * and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 *
 * */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if(A==null || A.length==0)return 0;
        if (A.length==1 || A[0]==A[A.length-1])return 1;
        int count = 1;
        for(int i=1;A[i]<A[A.length-1];i++){
            if (A[i]!=A[i-1])
                A[count++] = A[i];

        }
        A[count++] = A[A.length-1];
        return count;
    }
}
