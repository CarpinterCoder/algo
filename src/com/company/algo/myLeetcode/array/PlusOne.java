package com.company.algo.myLeetcode.array;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 9:06 2018/7/31
 */
/**
 * Given a number represented as an array of digits, plus one to the number.
 * */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits==null || digits.length==0)return new int[]{1};
        int carry = 1;
        for (int i=digits.length-1;i>=0 && carry!=0;i--){
            int sum = digits[i]+carry;
            digits[i] = sum%10;
            carry = sum/10;
        }
        if (carry==1){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            System.arraycopy(digits,0,result,1,result.length-1);
            return result;
        }

        return digits;
    }
}
