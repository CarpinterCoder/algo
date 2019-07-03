package com.company.algo.myLeetcode.array;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 16:37 2018/7/31
 */
/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * • Each child must have at least one candy.
 * • Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings==null)return 0;
        if (ratings.length<2)return ratings.length;
        int[] candys = new int[ratings.length];
        //左边第一个值赋1，正向扫描一遍，如果右边的rating比左边高，那么右边的糖果数就比左边多一个，否则只给一个糖果
        candys[0] = 1;
        for (int i=1;i<candys.length;i++){
            if (ratings[i]>ratings[i-1])
                candys[i] = candys[i-1]+1;
            else
                candys[i] = 1;
        }
        //反向扫描一遍，如果左边的rating比右边高，并且左边的糖果数比右边少，那么左边的糖果数应比右边多一
        for (int i=ratings.length-2;i>=0;i--){
            if (ratings[i]>ratings[i+1])
                candys[i] = Math.max(candys[i],candys[i+1]+1);
        }
        int total = 0;
        for (int i=0;i<candys.length;i++)
            total += candys[i];
        return total;
    }
}
