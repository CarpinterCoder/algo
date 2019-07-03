package com.company.algo.myLeetcode.greedy;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 19:25 2018/8/7
 */
/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 * */
public class JumpGame2 {
    public boolean canJump(int[] A) {
        if (A.length<2 || A[0]>=A.length-1) return true;
        //数组maxDis[n]表示：跳n次能够到达的最大索引
        int[] maxDis = new int[A.length];
        maxDis[0] = 0;
        maxDis[1] = A[0];
        for (int n=2;n<maxDis.length;n++){
            for (int oldPos=n-1;oldPos<=maxDis[n-1];oldPos++){
                maxDis[n] = Math.max(maxDis[n],oldPos + A[oldPos]);
                if (maxDis[n]>=A.length-1)
                    return true;
            }
        }
        return false;
    }
}
