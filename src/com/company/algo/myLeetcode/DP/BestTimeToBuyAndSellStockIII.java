package com.company.algo.myLeetcode.DP;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 16:50 2018/8/10
 */
/**
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before
 * you buy again).
 *
 * */
public class BestTimeToBuyAndSellStockIII {
    public static int maxProfit(int[] prices) {
        if (prices==null || prices.length<2)
            return 0;
        int[] profits = new int[prices.length-1];
        for (int i=0;i<profits.length;i++)
            profits[i] = prices[i+1]-prices[i];

        int maxProfit = Integer.MIN_VALUE;
        for (int k=0;k<profits.length;k++){
            //1~K+2天最大利润
            int mp1 = maxProfit(0,k,profits);
            //k+2~n天最大利润
            int mp2 = maxProfit(k+1,profits.length-1,profits);

            int profit=0;
            if (mp1>0)
                profit+=mp1;
            if (mp2>0)
                profit+=mp2;

            maxProfit = Math.max(profit,maxProfit);
        }

        return maxProfit;
    }

    private static int maxProfit(int start, int end, int[] profits) {
        if (start<0 || end<0 || start>=profits.length || end>=profits.length)
            return 0;
        if (start>=end)
            return profits[start];

        //f[i]：以profits[i+start]为最后一个元素的最大连续元素之和
        int[] f = new int[end-start+1];
        int maxProfit = Integer.MIN_VALUE;
        f[0] = profits[start];
        for (int i=1;i<f.length;i++){
            f[i] = Math.max(profits[i+start],profits[i+start]+f[i-1]);
            maxProfit = Math.max(maxProfit,f[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args){
        int[] arr = new int[]{3,2,6,5,0,3};
        System.out.println(maxProfit(arr));
    }
}
