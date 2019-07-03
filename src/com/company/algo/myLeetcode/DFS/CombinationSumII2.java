package com.company.algo.myLeetcode.DFS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 16:04 2018/8/13
 */
/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in
 * C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * • All numbers (including target) will be positive integers.
 * • Elements in a combination (a1; a2; :::; ak) must be in non-descending order. (ie, a1 > a2 > ::: > ak).
 * • The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 *
 * */
public class CombinationSumII2 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num==null || num.length==0 || target==0)
            return res;

        Arrays.sort(num);
        dfs(res, new ArrayList<Integer>(),num,target,0);
        return res;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] num, int target, int start) {

        if (target==0){
            res.add(new ArrayList<Integer>(tmp));
            return false;
        }

        if (target<0)
            return false;

        for (int i=start;i<num.length;i++){
            if (i>start && num[i]==num[i-1])
                continue;
            tmp.add(num[i]);
            int nextTarget = target-num[i];

            boolean flag = dfs(res,tmp,num,nextTarget,i+1);
            tmp.remove(tmp.size()-1);
            if (!flag)
                break;
        }

        return true;
    }
}
