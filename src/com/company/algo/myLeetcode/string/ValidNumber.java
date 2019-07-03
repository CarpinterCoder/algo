package com.company.algo.myLeetcode.string;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 9:01 2018/8/5
 */
/**
 * 所有的数字字符有：'0'~'9' '.' 'e'/'E' '+' '-'
 * '0'~'9'可以在数字的任何位置
 * 'e'/'E'只能在中间，其后不能有'.'
 * '.'可以在任何位置，除了e以后的位置，且只能出现一次
 * '+' '-'只能在开头和'e'的后一位，且只能出现其中一个
 *
 */
public class ValidNumber {
    public static boolean isNumber(String s) {
        if (s==null) return false;
        s = s.trim().toLowerCase();
        if (s.length()==0)return false;

        boolean isDecimals = false;
        boolean isExponent = false;
        boolean hasNumber = false;

        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if ('0'<=c && c<='9')
                hasNumber = true;
            else if (c=='.'){
                if (isDecimals || isExponent)
                    return false;
                isDecimals = true;
            }else if (c=='+' || c=='-'){
                if (i!=0 && s.charAt(i-1)!='e' || i==s.length()-1)
                    return false;
            }else if (c=='e'){
                if (isExponent || !hasNumber || i==s.length()-1)
                    return false;
                isExponent = true;
            }else
                return false;
        }


        return hasNumber?true:false;
    }

    public static void main(String[] args){
        System.out.println(isNumber("05e+0055"));
    }
}
