package com.company.algo.myLeetcode.array;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 10:32 2018/7/28
 */
/* Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A==null || A.length==0)return -1;
        int lo = 0;
        int hi = A.length-1;

        while (lo<hi){
            if (A[hi]<target && target<A[lo])return -1;
            if (A[lo]==target)return lo;
            if (A[hi]==target)return hi;
            int mid = (lo+hi)/2;
            if (target==A[mid])return mid;
            if (A[lo]<target){
                if (target<A[mid]){
                    hi = mid;
                    break;
                }else if (target>A[mid]){
                    if (A[mid]>A[lo])
                        lo = mid+1;
                    else
                        hi = mid-1;
                }
            }else if (A[lo]>target){
                if (target>A[mid]){
                    lo = mid;
                    break;
                }else if (target<A[mid]){
                    if (A[mid]<A[hi]){
                        hi = mid-1;
                    }else if (A[mid]>A[hi]){
                        lo = mid+1;
                    }
                }
            }
        }

        while (lo<=hi){
            int mid = (lo+hi)/2;
            if (A[mid]>target){
                hi = mid-1;
            }else if (A[mid]<target){
                lo = mid+1;
            }else {
                return mid;
            }
        }

        return -1;
    }
}
