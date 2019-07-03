package com.company.algo.myLeetcode.greedy;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 23:16 2018/8/7
 */
public class BestTimeToBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<2)
            return 0;

        int profit = 0;
        for (int i=0;i<prices.length-1;i++){
            profit+=Math.max(0,prices[i+1]-prices[i]);
        }

        return profit;
    }
}
