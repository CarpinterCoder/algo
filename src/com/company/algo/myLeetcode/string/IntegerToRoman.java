package com.company.algo.myLeetcode.string;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 11:46 2018/8/5
 */
/**
 *         1 I
 *         5 V
 *        10 X
 *        50 L
 *       100 C
 *       500 D
 *      1000 M
 *
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        //千位
        int kilo = num/1000;
        for (int i=1;i<=kilo;i++){
            sb.append('M');
        }

        //百位
        num%=1000;
        int hundred = num/100;
        if (hundred<5){
            if (hundred<=3){
                for (int i=1;i<=hundred;i++){
                    sb.append('C');
                }
            }else {
                sb.append("CD");
            }
        }else {
            if (hundred-5<=3){
                sb.append('D');
                for (int i=1;i<=hundred-5;i++)
                    sb.append('C');
            }else
                sb.append("CM");
        }

        //十位
        num%=100;
        int ten = num/10;
        if (ten<5){
            if (ten<=3){
                for (int i=1;i<=ten;i++)
                    sb.append('X');
            }else
                sb.append("XL");
        }else {
            if (ten-5<=3){
                sb.append('L');
                for (int i=1;i<=ten-5;i++)
                    sb.append('X');
            }else
                sb.append("XC");
        }

        //个位
        int unit = num%10;
        if (unit<5){
            if (unit<=3){
                for (int i=1;i<=unit;i++)
                    sb.append('I');
            }else
                sb.append("IV");
        }else {
            if (unit-5<=3){
                sb.append('V');
                for (int i=1;i<=unit-5;i++)
                    sb.append('I');
            }else
                sb.append("IX");
        }

        return sb.toString();
    }
}
