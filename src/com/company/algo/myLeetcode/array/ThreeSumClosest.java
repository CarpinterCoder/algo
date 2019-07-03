package com.company.algo.myLeetcode.array;

import java.util.Arrays;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 17:05 2018/7/29
 */
/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num==null || num.length<3)return 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(num);
        for (int i=0;i<num.length-2;i++){
            if (i==0 || num[i]!=num[i-1]){
                int lo = i+1, hi = num.length-1;
                while (lo<hi){
                    int diff1 = num[i] + num[lo] + num[hi] - target;
                    diff = Math.abs(diff1)<Math.abs(diff)?diff1:diff;
                    if (diff1>0)
                        hi--;
                    else if (diff1<0)
                        lo++;
                    else
                        return target;
                }
            }
        }
        return target+diff;
    }
}
