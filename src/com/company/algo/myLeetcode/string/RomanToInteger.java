package com.company.algo.myLeetcode.string;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 12:27 2018/8/5
 */
/**
 *          1  I
 *          5  V
 *         10  X
 *         50  L
 *        100  C
 *        500  D
 *       1000  M
 *
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        if (s==null || s.trim().length()==0)
            return 0;
        s = s.trim().toUpperCase();
        int sum = 0;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c=='M')
                sum+=1000;
            else if (c=='D'){
                sum+=500;
            }else if (c=='C'){
                if (i<s.length()-1 && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M'))
                    sum-=100;
                else
                    sum+=100;
            }else if (c=='L'){
                sum+=50;
            }else if (c=='X'){
                if (i<s.length()-1 && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C'))
                    sum-=10;
                else
                    sum+=10;
            }else if (c=='V'){
                sum+=5;
            }else if (c=='I'){
                if (i<s.length()-1 && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X'))
                    sum-=1;
                else
                    sum+=1;
            }else
                return sum;
        }

        return sum;
    }
}
