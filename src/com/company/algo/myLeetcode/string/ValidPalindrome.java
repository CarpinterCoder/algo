package com.company.algo.myLeetcode.string;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 9:16 2018/8/2
 */
/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring
 * cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note: Have you consider that the string might be empty? This is a good question to ask during an
 * interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s==null || s.trim().isEmpty())return true;
        s = s.trim().toLowerCase();
        int lo = 0,hi = s.length()-1;
        while (lo<hi){
            char loC = s.charAt(lo);
            char hiC = s.charAt(hi);
            if (loC<'0' || (loC>'9' && loC<'a') || loC>'z')
                lo++;
            if (hiC<'0' || (hiC>'9' && hiC<'a') || hiC>'z')
                hi--;
            if ((('0'<=loC && loC<='9') || ('a'<=loC && loC<='z'))
                    && (('0'<=hiC && hiC<='9') || ('a'<=hiC && hiC<='z'))){
                if (loC!=hiC)
                    return false;
                else {
                    lo++;
                    hi--;
                }
            }
        }
        return true;
    }
}
