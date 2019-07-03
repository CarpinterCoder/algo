package com.company.algo.myLeetcode.string;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 16:24 2018/8/5
 */
/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length
 * of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, Given s = "Hello World", return 5.
 * */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s==null || s.trim().length()==0)
            return 0;
        s = s.trim();
        int i = s.lastIndexOf(' ');
        if (i==-1)
            return s.length();

        return s.length()-1-i;
    }
}
