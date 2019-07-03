package com.company.algo.myLeetcode.greedy;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 20:35 2018/8/7
 */
/**
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the
 * stock), design an algorithm to find the maximum profit.
 * */
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length<2)return 0;
        int[] profit = new int[prices.length-1];
        for (int i=0;i<profit.length;i++){
            profit[i] = prices[i+1]-prices[i];
        }
        int[] f = new int[profit.length];
        f[0] = profit[0];
        for (int i=1;i<f.length;i++){
            f[i] = Math.max(profit[i],profit[i]+f[i-1]);
        }

        int maxProfit = 0;
        for (int i=0;i<f.length;i++){
            maxProfit = Math.max(maxProfit,f[i]);
        }
        return maxProfit;
    }
    public static void main(String[] args){
        int[] prices = {2,1,3,1,-2,1,2};
        System.out.println(maxProfit(prices));
    }

}
