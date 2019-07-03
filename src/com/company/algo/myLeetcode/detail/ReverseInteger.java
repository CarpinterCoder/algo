package com.company.algo.myLeetcode.detail;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 10:30 2018/8/27
 */
public class ReverseInteger {
    public static int reverse(int x) {
        boolean isNegative = (x<0);
        if (isNegative)
            x=-x;
        char[] chs = Integer.toString(x).toCharArray();
        int lo = 0,hi = chs.length-1;
        while (lo<hi){
            char tmp = chs[lo];
            chs[lo++] = chs[hi];
            chs[hi--] = tmp;
        }

        long res = Long.valueOf(new String(chs));
        if (isNegative)
            res = -res;
        if (res<Integer.MIN_VALUE || res>Integer.MAX_VALUE)
            return 0;

        return (int)res;

    }

    public static void main(String[] args){
        System.out.println(Integer.valueOf("001"));
        System.out.println(Integer.toString(-100));
    }
}
