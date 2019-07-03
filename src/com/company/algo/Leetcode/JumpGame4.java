package com.company.algo.Leetcode;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 19:52 2018/6/11
 */
public class JumpGame4 {
    public boolean canJump(int[] A) {
        if (A.length == 1)
            return true;
        if (A[0] >= (A.length - 1))
            return true;
        int maxlength = A[0];
        for (int i = 0; i <= maxlength; i++) {
            if ((i + A[i]) >= A.length - 1)
                return true;
            if ( A[i] == 0 && i==maxlength)
                return false;
            if ((i + A[i]) > maxlength)
                maxlength = i + A[i];
        }
        return false;
    }
}
