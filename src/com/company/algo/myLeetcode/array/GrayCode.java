package com.company.algo.myLeetcode.array;

import java.util.ArrayList;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 9:55 2018/7/31
 */

/**
 * 题目：生成长度为n的格雷码，此格雷码必须以0为开始
 * 要求：最终的结果以格雷码的十进制值列表输出
 *
 * 思路：利用格雷码的镜像原理，例如：n=3
 *                      000
 *                      001
 *                      011
 *                      010
 *                      110
 *                      111
 *                      101
 *                      100
 * 设f(n)为含有n个二进制位的格雷码列表，则f(n+1)可以由f(n)的元素加
 * 上2^n(=1<<n),依从右到左的次序依次添加到列表f(n)得到
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>(1<<n);
        list.add(0);
        for (int i=1;i<=n;i++){
            int added = 1<<(i-1);
            for (int j=added-1;j>=0;j--)
                list.add(list.get(j)+added);
        }
        return list;
    }
}
