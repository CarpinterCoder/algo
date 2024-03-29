package com.company.algo.myLeetcode.greedy;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 20:21 2018/8/7
 */
/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example: Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps
 * to the last index.)
 *
 * */
public class JumpGameII {
    public int jump(int[] A) {
        if (A.length<2)return 0;
        if (A[0]>=A.length-1)return 1;
        int[] maxDis = new int[A.length];
        maxDis[1] = A[0];
        for (int n=2;n<maxDis.length;n++){
            for (int oldPos=n-1;oldPos<=maxDis[n-1];oldPos++){
                maxDis[n] = Math.max(maxDis[n],oldPos+A[oldPos]);
                if (maxDis[n]>=A.length-1)
                    return n;
            }
        }

        return -1;
    }
}
