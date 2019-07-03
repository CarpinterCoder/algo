package com.company.algo.myLeetcode.sort.basic;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 19:38 2018/7/23
 */
/**
 * 思想：就是取其中一个数(一般去数组的第一个数)，将大于等于该数的所有数放在它左边，小于等于该数的放在它右边
 *      然后对切分后的两边的数组递归地采用这一切分方式，直到各个子数组只有一个元素
 *
 *      时间复杂度：O(NlgN)
 *      最理想情况：每次切分都对半分(即切分元素正好是中位数)
 *      最坏情况：每次切分只分出一个元素，其时间复杂度为O(N^2)其比较次数为((N-1)+(N-2)+...+3+2+1)=(N^2)/2
 *
 */
public class QuickSort {
    public void sort(int[] data){
        quickSort(data,0,data.length-1);
    }

    private void quickSort(int[] data, int lo, int hi) {
        if (lo>=hi)return;
        int j = partition(data,lo,hi);
        quickSort(data,lo,j-1);
        quickSort(data,j+1,hi);
    }

    private int partition(int[] data, int lo, int hi) {
        int v = data[lo];
        int i = lo;
        int j = hi+1;
        while (true){
            while (v>data[++i]){
                if (i==hi)break;
            }
            if (v<data[--j]){
                if (j==lo)break;
            }
            if (i>=j)break;
            SortUtils.swap(data,i,j);
        }
        SortUtils.swap(data,lo,j);
        return j;
    }
}
