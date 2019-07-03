package com.company.algo.myLeetcode.DFS;

import java.util.ArrayList;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 14:15 2018/8/12
 */
/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab", Return
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * */
public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s==null || s.length()<=1){
            ArrayList<String> list = new ArrayList<String>(1);
            if (s!=null)
                list.add(s);
            res.add(list);
            return res;
        }

        char[] chs = s.toCharArray();
        partition(chs,0,chs.length-1,res);
        return res;
    }

    private void partition(char[] chs, int lo, int hi, ArrayList<ArrayList<String>> res) {
        if (lo>hi){
            res.add(new ArrayList<String>());
            return;
        }


        while (lo<=hi){
            if(isPalindrome(chs,lo,hi)){
                int slo = hi+1;
                int shi = chs.length-1;
                ArrayList<ArrayList<String>> tmp = new ArrayList<ArrayList<String>>();
                partition(chs,slo,shi,tmp);
                for (ArrayList<String> list:tmp){
                    list.add(0,new String(chs,lo,hi-lo+1));
                }
                res.addAll(new ArrayList<ArrayList<String>>(tmp));
            }
            hi--;
        }

    }

    private boolean isPalindrome(char[] chs, int lo, int hi) {
        while (lo<=hi){
            if (chs[lo]!=chs[hi])
                return false;
            lo++;
            hi--;
        }
        return true;
    }


}
