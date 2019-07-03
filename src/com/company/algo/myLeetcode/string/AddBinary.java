package com.company.algo.myLeetcode.string;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 14:24 2018/8/2
 */
/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * */
public class AddBinary {
    public static String addBinary(String a, String b) {
        // write your code here
        if ((a==null && b==null) || (a.length()==0 && b.length()==0))
            return "0";

        if (a==null || a.length()==0)
            return b;

        if (b==null || b.length()==0)
            return a;

        StringBuilder res = new StringBuilder();
        int carry = 0;
        int ai = a.length()-1,bi = b.length()-1;
        while (ai>=0 && bi>=0){
            int ac = a.charAt(ai)-'0',bc = b.charAt(bi)-'0';
            int sum = ac+bc+carry;
            int val = sum%2;
            carry = sum/2;
            res.insert(0,(char)(val+'0'));
            ai--;
            bi--;
        }

        while (ai>=0 && carry>0){
            int ac = a.charAt(ai)-'0';
            int sum = ac + carry;
            int val = sum%2;
            carry = sum/2;
            res.insert(0,(char)(val+'0'));
            ai--;
        }

        if (ai>=0){
            StringBuilder sb = new StringBuilder(a.substring(0,ai+1));
            res = sb.append(res);
        }

        while (bi>=0 && carry>0){
            int bc = b.charAt(bi)-'0';
            int sum = bc + carry;
            int val = sum%2;
            carry = sum/2;
            res.insert(0,(char)(val+'0'));
            bi--;
        }

        if (bi>=0){
            StringBuilder sb = new StringBuilder(b.substring(0,bi+1));
            res = sb.append(res);
        }

        if (carry>0)
            res.insert(0,(char)(carry+'0'));

        return res.toString();
    }
}
