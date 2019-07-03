package com.company.algo.myLeetcode.array;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 20:04 2018/7/31
 */
/**
 * 给定一个整数数组，其中只有一个数字出现一次，其它数字都出现三次，找出只出现一次的数字
 * 要求：时间复杂度：O(n)，空间复杂度：O(1)
 *
 * 思路：
 *     用一个3长度为32的int数组bits记录数组A中每一个整数对应二进制位的累加和；
 *     扫描bits数组，将每一个元素对3取余，若为0，忽略；若为1，则取出组成答案
 *
 */
public class SingleNumberII {
    public static int singleNumber(int[] A) {
        if (A==null || A.length==0)return 0;
        int[] bits = new int[32];//数组bits记录整数的32个二进制位的累加和，从左到右依次由低位到高位
        for (int i=0;i<A.length;i++){
            for (int l=0;l<32;l++){
                bits[l] += (A[i]>>l&1);
            }
        }
        int res = 0;
        for (int i=0;i<32;i++){
            int b = bits[i]%3;
            res += (b<<i);
        }

        return res;
    }
    public static void main(String[] args){
        int[] A = new int[]{2,2,3,2};
        singleNumber(A);
    }

}
