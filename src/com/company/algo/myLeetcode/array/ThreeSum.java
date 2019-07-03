package com.company.algo.myLeetcode.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 16:18 2018/7/29
 */
/**
 * Given an array S of n integers, are there elements a; b; c in S such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 * Note:
 * • Elements in a triplet (a; b; c) must be in non-descending order. (ie, a  b  c)
 * • The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4}.
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 *
 * */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (num==null || num.length<3)return lists;
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){
            if (i==0 || num[i]!=num[i-1]){
                int lo = i+1,hi = num.length-1;
                while (lo<hi){
                    if (num[lo]+num[hi]<-num[i])
                        lo++;
                    else if (num[lo]+num[hi]>-num[i])
                        hi--;
                    else{
                        ArrayList<Integer> list = new ArrayList<Integer>(3);
                        list.add(num[i]);
                        list.add(num[lo++]);
                        list.add(num[hi--]);
                        lists.add(list);
                        while (lo<hi && num[lo]==num[lo-1])
                            lo++;
                        while (lo<hi && num[hi]==num[hi+1])
                            hi--;
                    }
                }
            }
        }
        return lists;
    }
}
