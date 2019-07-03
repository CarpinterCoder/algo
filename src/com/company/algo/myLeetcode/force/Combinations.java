package com.company.algo.myLeetcode.force;

import java.util.ArrayList;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 11:31 2018/8/10
 */
/**
 * Given a set of distinct integers, S, return all possible subsets.
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
 * */
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        addCombination(1,n,k,res);
        return res;
    }

    private void addCombination(int start, int n, int k, ArrayList<ArrayList<Integer>> res) {
        if (k<=0 || n-start+1<k)
            return;
        if (start==n-k+1){
            ArrayList<Integer> c = new ArrayList<Integer>(k);
            for (int i=start;i<=n;i++){
                c.add(i);
            }
            res.add(c);
            return;
        }

        if (k==1){
            for (int i=start;i<=n;i++){
                ArrayList<Integer> c = new ArrayList<Integer>();
                c.add(i);
                res.add(c);
            }
            return;
        }
        ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
        addCombination(start+1,n,k-1,tmp);
        for (ArrayList<Integer> c:tmp){
            c.add(start);
        }
        res.addAll(tmp);
        addCombination(start+1,n,k,res);
    }
}
