package com.company.algo.myLeetcode.array;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 18:00 2018/7/31
 */
/**
 * 给定一个整数数组，其中只有一个数字出现一次，其它数字都出现两次，找出只出现一次的数字
 * 要求：时间复杂度：O(n)，空间复杂度：O(1)
 *
 * 思路：异或：0^0=0 1^0=1 0^1=1 1^1=1
 *      与0异或值不变，与本身异或得0
 *      因此，将数组里的所有元素做异或运算，使得出现偶数次的元素均互相抵消，得到出现奇数次元素异或的结果，
 *      这里得到的是只出现一次的元素
 *
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        if (A==null)return 0;
        int res = 0;
        for (int i=0;i<A.length;i++)
            res^=A[i];
        return res;
    }
}
