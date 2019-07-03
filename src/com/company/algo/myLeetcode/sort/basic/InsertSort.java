package com.company.algo.myLeetcode.sort.basic;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 14:04 2018/7/23
 */
/**
 * 思想：将后续无序的序列一个一个地插入前面有序的序列中，利用有序序列已有的顺序信息，将要
 *      插入的元素，从大到小逐个比较，直到找到比插入元素小的元素，将待插入元素插入该元素的后面
 *
 * 时间复杂度：O(n^2)平方级别
 * 最理想的情况：序列已经是有序的：比较次数N-1；交换次数0
 * 最坏的情况：序列是反序的(由大到小排列)：比较次数(N^2)/2；交换次数(N^2)/2
 * 插入排序在倒置数量少、数组长度短的情况下比很多排序算法速度要快
 *
 * 插入排序：交换次数=倒置数量； 倒置数量<=比较次数<=倒置数量+N-1
 *
 * */
public class InsertSort {
    public void sort(int[] data){
        for (int i=1;i<data.length;i++){
            for (int j=i;j>0 && data[j]<data[j-1];j--){
                SortUtils.swap(data,j,j-1);
            }
        }
    }
}
