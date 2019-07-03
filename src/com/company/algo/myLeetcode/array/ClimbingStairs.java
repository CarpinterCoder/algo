package com.company.algo.myLeetcode.array;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 9:38 2018/7/31
 */
/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 分析：
 *      斐波那契数列
 *      设n个台阶有f(n)种方案，则有以下两种可能：
 *            1、第一次跨1个台阶，剩余n-1个台阶，则此类情况有f(n-1)种方案
 *            2、第一次跨2个台阶，剩余n-2个台阶，则此类情况有f(n-2)种方案
 *      因此，f(n)=f(n-1)+f(n-2)
 *      由此可知，数列{f(n)}(n=1,2,..,n,...)是一个斐波那契数列
 *
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n<=1)return 1;
        int[] f = new int[n];
        f[0]=1;//n=1;
        f[1]=2;//n=2;
        for (int i=2;i<n;i++)
            f[i]=f[i-1]+f[i-2];

        return f[n-1];
    }
}
