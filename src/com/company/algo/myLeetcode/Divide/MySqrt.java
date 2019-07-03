package com.company.algo.myLeetcode.Divide;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 16:46 2018/8/7
 */
/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 *
 * */
public class MySqrt {
    public static int sqrt(int x) {
        if (x==0 || x==1)return x;

        int lo = 1,hi = x;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            if (mid<x/mid){
                lo = mid+1;
            }else if (mid>x/mid){
                hi = mid-1;
            }else {
                return mid;
            }
        }

        return hi;
    }
    public static void main(String[] args){
        System.out.println(sqrt(2));
    }
}
