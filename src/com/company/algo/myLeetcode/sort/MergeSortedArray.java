package com.company.algo.myLeetcode.sort;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 16:12 2018/7/19
 */
/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note: You may assume that A has enough space to hold additional elements from B. The number of
 * elements initialized in A and B are m and n respectively.
 *
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int x=m-1;
        int y = n-1;
        int z=m+n-1;
        while (x>=0 && y>=0){
            if (A[x]>=B[y]){
                A[z--] = A[x--];
            }else {
                A[z--] = B[y--];
            }
        }
        while (y>=0){
            A[z--] = B[y--];
        }

    }
}
