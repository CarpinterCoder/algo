package com.company.algo.myLeetcode.detail;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 12:11 2018/8/27
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x<0)
            return false;

        if (x<10)
            return true;

        int[] tens = new int[10];
        tens[0] = 1;
        for (int i=1;i<10;i++)
            tens[i] = 10*tens[i-1];

        int lo = 0,hi = 0;
        for (int i=9;i>=1;i--){
            if (x/tens[i]>0){
                hi = i;
                break;
            }
        }
        while (lo<hi){
            int loNum = x%10;
            x/=10;
            hi--;
            int hiNum = x/tens[hi];
            x%=tens[hi];
            if (loNum!=hiNum)
                return false;
            lo++;
            hi--;
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome(12344321));
    }
}
