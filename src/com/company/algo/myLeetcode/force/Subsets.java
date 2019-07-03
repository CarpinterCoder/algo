package com.company.algo.myLeetcode.force;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 19:42 2018/8/9
 */

/**
 *Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * • Elements in a subset must be in non-descending order.
 * • The solution set must not contain duplicate subsets.
 * For example, If S = [1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if (S==null) return null;
        Arrays.sort(S);
        int len = S.length;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>(1<<len);
        if (len==0)
            return lists;
        for (int i=0;i<=(1<<len)-1;i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            int n = 1;
            for (int k=0;k<len;k++){
                if (((i&n)>>k)==1){
                    list.add(S[k]);
                }
                n<<=1;
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args){

    }
}
