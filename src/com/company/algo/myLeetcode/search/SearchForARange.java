package com.company.algo.myLeetcode.search;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 19:34 2018/7/24
 */
/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 *
 *
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        if (A==null || A.length==0)return new int[]{-1,-1};
        int lo = 0;
        int hi = A.length-1;

        while (lo<=hi){
            int mid = (lo+hi)/2;
            if (A[mid]>target){
                hi = mid-1;
            }else if (A[mid]<target){
                lo = mid+1;
            }else
                for (int i=mid,j=mid;;){
                    while (i-1>=0 && A[i-1]==target)i--;
                    while (j+1<=A.length-1 && A[j+1]==target)j++;
                    return new int[]{i,j};
                }
        }
        return new int[]{-1,-1};

    }
}
