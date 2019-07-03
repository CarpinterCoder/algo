package com.company.algo.myLeetcode.string;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 9:57 2018/8/2
 */
/**
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack==null || needle==null)
            return -1;
        return haystack.indexOf(needle);
    }
}
