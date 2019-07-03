package com.company.algo.myLeetcode.sort.basic;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 17:29 2018/7/23
 */
/**
 * 思想：将两个有序数组归并为更大的数组
 *
 *  自底向上归并排序：不需要递归，减少栈内存使用
 *  时间复杂度：O(NlgN)
 *  空间消耗：O(N)
 *
 */
public class MergeSort2 {
    public int[] temp;

    public void sort(int[] data){
        if (data==null || data.length==0 || data.length==1)return;
        int N = data.length;
       for (int sz=1;sz<=N/2;sz*=2){
           for (int lo=0;lo<N-2*sz;lo+=2*sz){
               merge(data,lo,Math.min(N-1,lo+2*sz-1),lo+sz-1);
           }
       }

    }

    private void merge(int[] data, int lo, int hi, int mid) {
        for (int i=lo;i<=hi;i++)
            temp[i] = data[i];

        for (int cur=0,i=lo,j=mid+1;cur<data.length;cur++){
            if (i>mid)
                data[cur]=temp[j++];
            else if (j>hi)
                data[cur] = temp[i++];
            else if (data[i]<data[j])
                data[cur] = temp[i++];
            else
                data[cur] = temp[j++];
        }
    }
}
