package com.company.algo.myLeetcode.sort.basic;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 14:55 2018/7/23
 */
/**
 * 思想：利用插入排序在数组长度短或部分有序数组中的优越性能
 *      分组插入排序：排序之初，各个子数组长度较短；排序之后，各个子数组都是部分有序的
 *
 *      最理想情况：数组已经有序：比较次数：O(N)级别(大概为k*N，其中k为循环计算出的h值在h序列中索引位置)；交换次数0
 *      最坏情况：数组反序：比较次数/交换次数：O(N^(3/2))，比插入排序的O(N^2)级别有所改善
 *
 *      适用性：当数组长度较长，无序状况下，用shell排序较好
 *             当数组长度较短或部分有序时，用插入排序较好
 *
 */
public class ShellSort {
    public void sort(int[] data){
        int h = 1;
        //h序列：1,4,13,40,121,364,1093,...
        while (h<data.length/3) h=3*h+1;

        while (h>1){
            for (int i=h;i<data.length;i++){
                for (int j=i;j>=h && data[j]<data[j-h];j-=h){
                    SortUtils.swap(data,j,j-h);
                }
            }
            h/=3;
        }
    }
}
