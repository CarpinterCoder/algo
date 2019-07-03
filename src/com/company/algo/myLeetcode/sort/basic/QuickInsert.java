package com.company.algo.myLeetcode.sort.basic;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 21:17 2018/7/23
 */
/**
 * 思想：利用插入排序在短小数组中的优越性
 *
 * 原理：当数组长度小于等于M时，采用插入排序；大于M时采用快速排序
 *          M一般取5~15中任意值
 *
 * */
public class QuickInsert {
    public void sort(int[] data){
        int M = 5;
        quickSort(data,0,data.length-1,M);
    }

    private void quickSort(int[] data, int lo, int hi, int m) {
        if (hi-lo<m) {
            insert(data,lo,hi);
            return;
        }

        int j = partition(data,lo,hi);
        quickSort(data,lo,j-1,m);
        quickSort(data,j+1,hi,m);
    }

    private int partition(int[] data, int lo, int hi) {
        int v = data[lo];
        int i = lo;
        int j = hi+1;

        while (true){
            while (v>data[++i]){
                if(i==hi)break;
            }
            while (v<data[--j]){
                if (j==lo)break;
            }
            if (i>=j)break;
            SortUtils.swap(data,i,j);
        }

        SortUtils.swap(data,lo,j);
        return j;
    }

    private void insert(int[] data, int lo, int hi) {
        for (int i=1;i<data.length;i++){
            for (int j=i;j>0 && data[j]<data[j-1];j--){
                SortUtils.swap(data,j,j-1);
            }
        }
    }
}
