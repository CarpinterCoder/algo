package com.company.algo.myLeetcode.force;

import java.util.ArrayList;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 10:14 2018/8/10
 */
/**
 * Given a collection of numbers, return all possible permutations.
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1],
 * [3,1,2], and [3,2,1].
 *
 * */
public class Permutations2 {
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i=0;i<num.length;i++){
            ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> e:res){
                //将num[i](第i+1个)插入到前i个元素全排列中每一个排列的不同位置，组陈前i+1个元素的全排列
                for (int j=0;j<e.size()+1;j++){
                    ArrayList<Integer> tmp = new ArrayList<Integer>(e);
                    tmp.add(j,num[i]);
                    cur.add(tmp);
                }
            }
            res = new ArrayList<ArrayList<Integer>>(cur);
        }
        return res;
    }
}
