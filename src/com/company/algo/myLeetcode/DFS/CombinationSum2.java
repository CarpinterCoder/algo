package com.company.algo.myLeetcode.DFS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 15:42 2018/8/13
 */
/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where
 * the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * • All numbers (including target) will be positive integers.
 * • Elements in a combination (a1; a2; :::; ak) must be in non-descending order. (ie, a1  a2  :::  ak).
 * • The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, A solution set is:
 * [7]
 * [2, 2, 3]
 * */
public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (candidates==null || candidates.length==0 || target<=0)
            return res;

        Arrays.sort(candidates);
        dfs(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] candidates, int target, int start) {
        if (target==0){
            res.add(new ArrayList<Integer>(tmp));
            return false;
        }
        if (target<0)
            return false;

        for (int i=start;i<candidates.length;i++){
            boolean flag = false;
            tmp.add(candidates[i]);
            int nextTarget = target-candidates[i];
            flag = dfs(res,tmp,candidates,nextTarget,i);
            tmp.remove(tmp.size()-1);
            if (!flag)
                break;
        }
        return true;
    }
}
