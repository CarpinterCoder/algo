package com.company.algo.myLeetcode.greedy;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 17:39 2018/8/7
 */
/**
 *
 * 递归版
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        int start = 0;
        return canGet(start,A);
    }

    private boolean canGet(int start, int[] A) {
        if (A.length-1-start<=A[start])
            return true;

        if (start<A.length-1 && A[start]==0)
            return false;

        boolean res = false;
        for (int step=1;step<=A[start];step++){
            res = res || canGet(step+start,A);
        }

        return res;

    }
}
