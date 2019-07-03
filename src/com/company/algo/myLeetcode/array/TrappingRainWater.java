package com.company.algo.myLeetcode.array;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 21:51 2018/7/30
 */
/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute
 * how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 * */
public class TrappingRainWater {
    public int trap(int[] A) {
        if (A==null || A.length<3)return 0;
        int sum = 0;
        for (int i=1;i<A.length-1;i++){
            int lmax = 0, rmax = 0;
            for(int left=i-1;left>=0;left--)
                lmax = Math.max(lmax,A[left]);
            for (int right=i+1;right<A.length;right++)
                rmax = Math.max(rmax,A[right]);
            int area = Math.min(lmax,rmax)-A[i];
            if (area>0)
                sum+=area;
        }
        return sum;
    }
}
