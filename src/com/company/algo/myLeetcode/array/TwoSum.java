package com.company.algo.myLeetcode.array;

import java.util.HashMap;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 15:42 2018/7/29
 */
/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where
 * index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not
 * zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers==null || numbers.length<=1)return null;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>(numbers.length);
        for (int i=0;i<numbers.length;i++){
            int diff = target-numbers[i];
            if (map.containsKey(diff)){
                return new int[]{map.get(diff)+1,i+1};
            }
            map.put(numbers[i],i);
        }

        return null;
    }
}
