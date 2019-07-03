package com.company.algo.myLeetcode.array;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 17:41 2018/7/29
 */
/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn’t matter what you leave beyond the new length.
 *
 * */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if (A==null || A.length==0)return 0;
        int hi = A.length-1;
        for (int i=0;i<=hi;i++){
            while (A[i]==elem && hi>=i){
                A[i] = A[hi];
                hi--;
            }
        }
        return hi+1;

    }
}
