package com.company.algo.myLeetcode.Divide;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 14:18 2018/8/7
 */
/**
 * Implement pow(x, n).
 * */
public class PowXn {
    public static double pow(double x, int n) {
        if (x==1 || x==0)return x;

        boolean isNegative = false;

        if (n<0){
            //考虑位溢出问题
            //int型范围：正数：0~(2^31)-1; 负数：-1~-2^32
            //当n=-2^32时，取反发生溢出
            //解决方案：result = p(x,n+1)*(1/x)
            if (n==Integer.MIN_VALUE){
                return pow(x,n+1)*(1/x);
            }
            n=-n;
            isNegative = true;
        }

        double result = 1;

        //n为奇数：x^n=(x^2)^(n/2)*x
        //n为偶数：x^n=(x^2)^(n/2)
        while (n>0){
            if((n&1)==1)
                result*=x;
            n>>=1;
            x*=x;
        }

        return isNegative?1/result:result;

    }

    public static void main(String[] args){
        System.out.println(pow(2.,Integer.MIN_VALUE));
        System.out.println(Math.pow(2,Integer.MIN_VALUE));
    }
}
