package com.company.algo.myLeetcode.array;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 15:49 2018/7/28
 */
/**
 * Follow up for ”Search in Rotated Sorted Array”: What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 *
 * */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if (A==null || A.length==0)return false;
        int lo = 0;
        int hi = A.length-1;

        while (lo<=hi){
//            if (A[lo]==target || A[hi]==target)
//                return true;

            int mid = (lo+hi)>>1;
            if (target==A[mid])
                return true;
            if (A[mid]>A[lo]){
                if (A[lo]<=target && target<A[mid])
                    hi = mid-1;
                else
                    lo = mid+1;
            } else if (A[mid]<A[lo]){
                if (A[mid]<target && target<=A[hi])
                    lo = mid+1;
                else
                    hi = mid-1;
            }else if (A[mid]==A[lo]){
                lo++;
            }

        }
        return false;
    }
}
