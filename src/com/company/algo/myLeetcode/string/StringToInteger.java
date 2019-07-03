package com.company.algo.myLeetcode.string;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 10:26 2018/8/2
 */
/**
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and
 * ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible
 * to gather all the input requirements up front.
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace
 * character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by
 * as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored
 * and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such
 * sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the
 * range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * */
public class StringToInteger {
    public static int atoi(String str) {
        if (str==null)return 0;
        str = str.trim();
        boolean sign = true;
        boolean flag = false;
        int num = 0;
        long sum = 0;
        int i=0;

        while (i<str.length()){
            char c = str.charAt(i);
            if (c=='+' && !flag){
                sign = true;
                flag = true;
            }else if (c=='-' && !flag){
                sign = false;
                flag = true;
            }else if (c>='0' && c<='9'){
                num = c-'0';
                flag = true;
            }else if (c==' ' && !flag){

            }else
                break;
            i++;
            sum = sum*10 + num;
            if (sum>Integer.MAX_VALUE)
                return sign?Integer.MAX_VALUE:Integer.MIN_VALUE;

        }
        return sign?(int)sum:(int)-sum;
    }
    public static void main(String[] args){
        String s = "   +5599fjgs9";
        System.out.println(atoi(" -01"));
    }
}
