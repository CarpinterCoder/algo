package com.company.algo.myLeetcode.string;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 16:47 2018/8/2
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s==null || s.length()<2)return s;
        int mid = (s.length()>>1)-1;
        int index = mid;
        if ((s.length()&1)==1){
            index++;
            mid++;
        }

        String longest = "";
        while (index>=0){
            int left = index-1;
            int right = index+1;
            while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }

            if (right==s.length())
                right = s.length();
            String ss = s.substring(left+1,right);
            longest = ss.length()>longest.length()?ss:longest;
            if (ss.length()==s.length())
                return ss;

            left = index;
            right = left+1;
            if (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                    left--;
                    right++;
                }
                if (right==s.length())
                    right = s.length();
                ss = s.substring(left+1,right);
                longest = ss.length()>longest.length()?ss:longest;
                if (ss.length()==s.length())
                    return ss;
            }
            index--;
        }
        index = mid+1;
        while (index<s.length()){
            int left = index-1;
            int right = index+1;
            while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if (right==s.length())
                right = s.length();
            String ss = s.substring(left+1,right);
            longest = ss.length()>longest.length()?ss:longest;
            if (ss.length()==s.length())
                return ss;

            left = index;
            right = left+1;
            if (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                    left--;
                    right++;
                }
                if (right==s.length())
                    right = s.length();
                ss = s.substring(left+1,right);
                longest = ss.length()>longest.length()?ss:longest;
                if (ss.length()==s.length())
                    return ss;
            }
            index++;
        }
        return longest;
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("aa"));
    }
}
