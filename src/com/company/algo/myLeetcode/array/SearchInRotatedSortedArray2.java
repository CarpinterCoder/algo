package com.company.algo.myLeetcode.array;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 15:26 2018/7/28
 */
/* Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray2 {
    public int search(int[] A, int target) {
        if (A==null || A.length==0)return -1;
        int lo = 0;
        int hi = A.length-1;

        while (lo<=hi){
            if (target==A[lo])return lo;
            if (target==A[hi])return hi;
            int mid = (lo+hi)>>1;
            if (target==A[mid])return mid;
            if (A[mid]>A[lo]){
                if (A[lo]<target && target<A[mid])
                    hi = mid-1;
                else
                    lo = mid+1;
            }else {
                if (A[mid]<target && target<A[hi])
                    lo = mid+1;
                else
                    hi = mid-1;
            }
        }
        return -1;
    }
}
