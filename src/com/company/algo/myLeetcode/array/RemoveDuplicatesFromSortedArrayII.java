package com.company.algo.myLeetcode.array;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 21:11 2018/7/27
 */
/**
 * Follow up for ”Remove Duplicates”: What if duplicates are allowed at most twice?
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3]
 * 思路：设置count，作为插入值的索引
 *                     count
 *       1    1     2    2    2    2    2    5   5   5   6   6   6   9   9   9   9   9
 *                                i-1   i   i+1
 *     如图，当count指向索引A[3]时，当索引i走到图中位置时(此时A[i-1]=A[i]=A[i+1]不成立)，执行A[3]=A[i]
 *
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A==null)return 0;
        if (A.length<=2)return A.length;
        int count = 1;
        for (int i=1;i<A.length-1;i++){
            if (!(A[i-1]==A[i] && A[i]==A[i+1]))
                A[count++]=A[i];
        }
        A[count++] = A[A.length-1];
        return count;
    }
}
