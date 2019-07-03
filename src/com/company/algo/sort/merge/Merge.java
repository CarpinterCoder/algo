package com.company.algo.sort.merge;

/**
 * @Description: (自顶向下)归并排序
 * @Author:XiaoNing
 * @Date:Greated in 13:33 2018/6/9
 */
/**
 * 归并操作(merge)，也叫归并算法，指的是将两个已经排序的序列合并成一个序列的操作。
 *  先递归地将数组分成两半分别排序，然后将结果归并起来，
 *  依次类推， 当出来的小只有一个数据时可以认为这个小组内已经达到了有序，然后再合并相邻的二个小组就OK了。
 *
 *  优点：任意长度为N的数组排序时间和NlogN成正比
 *  缺点：所需要的额外空间和N成正比
 *
 * 首先考虑下如何将二个有序数列合并。
 * 只要比较两个数列的 第一个数， 谁小就先取谁，取了后在对应列中删除这个元素。
 * 然再进行比较如果有数列为空，那直接将另一个的据依次取出即可。
 */
public class Merge {
    private int[] aux;

    public void sort(int[] data){
        aux = new int[data.length];
        sort(data,0,data.length-1);
    }

    private void sort(int[] data, int lo, int hi) {
        if(hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        sort(data,lo,mid);
        sort(data,mid+1,hi);
        merge(data,lo,mid,hi);
    }

    private void merge(int[] data, int lo, int mid, int hi) {
        for (int k=lo;k<=hi;k++)
            aux[k] = data[k];

        int l = lo,r = mid+1;
        for (int k=lo;k<=hi;k++){
            if (l>mid)data[k] = aux[r++];
            else if (r>hi)data[k] = aux[l++];
            else if (data[l]<data[r])data[k] = aux[l++];
            else data[k] = aux[r++];
        }
    }
}
