package com.company.algo.sort.quick;


import com.company.algo.utils.SortUtils;

/**
 * <p>
 *     用插入排序改进快速排序
 *          基本思想：利用插入排序在数组长度较小或部分有序的数组中性能比快速排序优越的性质
 *
 *      原理：当数组长度小于等于M时，采用插入排序法；M取5~15中的任意值大多数情况下能得到令人满意的结果
 * </p>
 * @Author:XiaoNing
 * @Date:Greated in 17:19 2018/6/9
 */
public class QuickInsert {
    public static void sort(int[] data, int M){
        sort(data,0,data.length-1,M);
    }

    private static void sort(int[] data,int lo,int hi,int M){
        //当数组长度小于等于M时，采用插入排序法；M取5~15中的任意值大多数情况下能得到令人满意的结果
        if (hi-lo<=M){
            insert(data,lo,hi);
            return;
        }
        int j = partition(data,lo,hi);
        sort(data,lo,j-1,M);
        sort(data,j+1,hi,M);
    }

    private static int partition(int[] data,int lo,int hi){
        int i = lo;
        int j = hi+1;
        int v = data[lo];

        while (true){
            while (data[++i]<v) if(i==hi) break;
            while (data[--j]>v) if (j==lo)break;
            if (i>=j)break;
            exch(data,i,j);
        }
        exch(data,lo,j);
        return j;
    }

    private static void insert(int[] data,int lo,int hi){
        if (lo>=hi)return;
        for (int i=1;i<data.length;i++){
            for (int j=i;j>0 && data[j]<data[j-1];j--){
                exch(data,j,j-1);
            }
        }
    }

    private static void exch(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
