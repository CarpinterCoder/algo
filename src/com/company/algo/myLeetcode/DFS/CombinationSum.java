package com.company.algo.myLeetcode.DFS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 11:22 2018/8/13
 */

/**
 *
 * 超时
 */
@Deprecated
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (candidates==null || candidates.length==0 || target<=0)
            return res;

        Arrays.sort(candidates);

        dfs(res,candidates,target,candidates.length-1);
        return res;
    }

    private void dfs(ArrayList<ArrayList<Integer>> res, int[] candidates, int target,int end) {
        if (target==0){
            res.add(new ArrayList<Integer>());
            return;
        }
        if (target<candidates[0])
            return;
        int lo = 0,hi = end;
        int maxIndex = -1;
        if (target<candidates[end]){
            while (lo<=hi){
                int mid = lo+(hi-lo)/2;
                if (candidates[mid]>target)
                    hi = mid-1;
                else if (candidates[mid]<target)
                    lo = mid+1;
                else{
                    maxIndex = mid;
                }

            }
        }

        if (maxIndex==-1)
            maxIndex = hi;

        for (int first=maxIndex;first>=0;first--){
            int ele = candidates[first];
            int nextTarget = target-ele;
            int limit = first;

            ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
            dfs(tmp,candidates,nextTarget,limit);
            for (ArrayList<Integer> l:tmp){
                l.add(ele);
            }
            res.addAll(tmp);
        }


    }
}
