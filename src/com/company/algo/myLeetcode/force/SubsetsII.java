package com.company.algo.myLeetcode.force;

import java.util.ArrayList;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 21:21 2018/8/9
 */
/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order. The solution set must not contain duplicate
 * subsets. For example, If S = [1,2,2], a solution is:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * */
public class SubsetsII {
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if (num==null || num.length==0)return res;

        for (int i=0;i<num.length;i++){
            ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
            //将res中的元素复制到tmp中
            for (ArrayList<Integer> list:res)
                tmp.add(new ArrayList<Integer>(list));

            //添加新元素
            for (ArrayList<Integer> list:tmp)
                list.add(num[i]);

            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(num[i]);
            tmp.add(single);
            res.addAll(new ArrayList<ArrayList<Integer>>(tmp));
            //遇到重复元素
            while (i+1<=num.length-1 && num[i+1]==num[i]){
                i++;
                for (ArrayList<Integer> list:tmp)
                    list.add(num[i]);

                res.addAll(new ArrayList<ArrayList<Integer>>(tmp));
            }
        }
        res.add(new ArrayList<Integer>());
        return res;
    }

    public static void main(String[] args){
        int[] num = {1,2,2};
        System.out.println(subsetsWithDup(num));
    }
}
