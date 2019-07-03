package com.company.algo.myLeetcode.DFS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 14:12 2018/8/13
 */

/**
 *
 * 超时
 */
@Deprecated
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num==null || num.length==0 || target<=0)
            return res;

        Arrays.sort(num);
        dfs(res, num, target, num.length - 1);
        return res;
    }

    private void dfs(ArrayList<ArrayList<Integer>> res, int[] num, int target, int end) {
        if (target==0){
            res.add(new ArrayList<Integer>());
            return;
        }

        if (target<num[0] || end<0)
            return;

        int lo = 0,hi=end;
        int maxIndex = -1;
        if(num[end]>target){
            while (lo<=hi){
                int mid = lo+(hi-lo)/2;
                if (num[mid]>target)
                    hi = mid-1;
                else if (num[mid]<target)
                    lo = mid+1;
                else
                    maxIndex = mid;
            }
        }

        if (maxIndex==-1)
            maxIndex = hi;

        for (int last=maxIndex;last>=0;last--){
            int ele = num[last];
            int nextTarget = target-ele;
            ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
            dfs(tmp,num,nextTarget,last-1);
            for (ArrayList<Integer> l:tmp){
                l.add(ele);
            }
            res.addAll(tmp);
        }
    }
}
