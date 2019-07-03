package com.company.algo.myLeetcode.force;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 15:47 2018/8/10
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
public class Combinations2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        addCombination(n,n,k,res);
        return res;
    }

    private void addCombination(int end, int n, int k, List<List<Integer>> res) {
        if (k<=0 || end<k)
            return;
        if (end==k){
            List<Integer> c = new ArrayList<Integer>(k);
            for (int i=1;i<=k;i++)
                c.add(i);
            res.add(c);
            return;
        }

        if (k==1){
            for (int i=1;i<=end;i++){
                List<Integer> c = new ArrayList<Integer>();
                c.add(i);
                res.add(c);
            }
            return;
        }

        List<List<Integer>> tmp = new ArrayList<List<Integer>>();
        addCombination(end-1,n,k-1,tmp);
        for (List<Integer> c:tmp)
            c.add(end);
        res.addAll(tmp);

        addCombination(end-1,n,k,res);
    }
}
