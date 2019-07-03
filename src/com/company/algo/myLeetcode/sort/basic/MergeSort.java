package com.company.algo.myLeetcode.sort.basic;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 16:08 2018/7/23
 */
/**
 * 思想：将两个有序数组归并为更大的数组
 *
 *    自顶向下归并排序：需要递归
 *    时间复杂度：O(NlgN)
 *    空间消耗：O(N)
 *
 */
public class MergeSort {
    public void sort(int[] data){
        int[] temp = new int[data.length];
        mergeSort(data,temp,0,data.length-1);
    }

    private void mergeSort(int[] data, int[] temp, int lo, int hi) {
        if (lo>=hi)return;
        int mid = (lo+hi)/2;

        mergeSort(data,temp,lo,mid);
        mergeSort(data,temp,mid+1,hi);

        merge(data,temp,lo,hi,mid);
    }

    private void merge(int[] data, int[] temp, int lo, int hi, int mid) {
        for(int i=lo;i<=hi;i++)
            temp[i] = data[i];

        for(int cur=lo,i=lo,j=mid+1;cur<=hi;cur++){
            if (i>mid)
                data[cur] = temp[j++];
            else if (j>hi)
                data[cur] = temp[i++];
            else if (temp[i]<temp[j])
                data[cur] = temp[i++];
            else
                data[cur] = temp[j++];
        }
    }
}
