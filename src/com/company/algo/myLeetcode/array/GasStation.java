package com.company.algo.myLeetcode.array;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 15:03 2018/7/31
 */
/**
 * 题目：环形路线上有N个加油站，每个加油站有汽油gas[i]，从每个加油站到下一站
 * 消耗汽油cost[i]，问从哪个加油站出发能够回到起始点，如果都不能则返回-1
 * （注意，解是唯一的）。
 *
 *  时间复杂度：O(n)
 *  思路：
 *           1、当gas总量小于cost总量，则从任何站出发都无法返回起点
 *           2、当gas总量大于等于cost总量时，若从起点出发到达每一个站(包括回到起点站)
 *              的gas-cost累计量均大于等于0，则从该起点站出发可以返回起点
 *
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int sum = 0;
        for(int i=0;i<diff.length;i++){
            diff[i] = gas[i]-cost[i];
            sum += diff[i];
        }
        if (sum<0)return -1;
        sum=0;//累计gas-cost
        int s = 0;//从第s站出发
        int i=0;//沿途经过第i站
        while (true){
            sum+=diff[i++];
            if (i==diff.length)i=0;
            if (sum<0){//从s站出发无法到达第i站，则从第i站出发
                if (s==diff.length-1)
                    break;
                sum=0;
                s = i;
                continue;
            }
            if (i==s)
                return s;
        }
        return -1;
    }
}
