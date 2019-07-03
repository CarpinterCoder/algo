package com.company.algo.myLeetcode.sort.basic;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 20:51 2018/7/19
 */

/**
 * 冒泡排序法  思路
 *      从数组左边开始，逐个比较相邻的元素，一旦左边大于右边则交换这两个相邻元素：
 *        第0次冒泡：将最大的元素冒泡到data[data.length-1-0]
 *        第1次冒泡：将第二大元素冒泡到data[data.length-1-1]
 *        ......
 *        第i次冒泡：将第i大元素冒泡到data[data.length-1-i]
 *
 *       若数组本身就是有序的，则第0次冒泡后，直接返回
 *时间复杂度：一般情况：O(n^2)(n+(n-1)+(n-2)+...+2+1)
 *           最好情况：O(n)
 * */
public class BubbleSort {
    public void sort(int[] data){
        boolean flag = true;
        for (int i=0;i<data.length-1;i++){
            for (int j=0;j<data.length-1-i;j++){
                if (data[j]>data[j+1]){
                    SortUtils.swap(data, j, j + 1);
                    flag = false;
                }
            }
            if (flag)return;
        }
    }
}
