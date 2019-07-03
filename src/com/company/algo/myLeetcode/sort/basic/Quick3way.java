package com.company.algo.myLeetcode.sort.basic;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 20:53 2018/7/23
 */
/**
 * 思想：快排在切分过程中确定了切分元素在数组中的位置，则数组中其它大小相等的元素位置也随之确定，
 *      采用普通快排，将对数组做重复的切分，因此采用三向切分法
 *
 * 原理：维护三个指针：lt、i、gt，使得：设切分元素值为v
 *             [lo,...,lt-1]中的元素小于v
 *             [lt,...,i-1]中元素等于v
 *             [i,...,gt]中的元素待判断
 *             [gt+1,...,hi]中的元素大于v
 *
 */
public class Quick3way {
    public void sort(int[] data){
        quick3way(data,0,data.length-1);
    }

    private void quick3way(int[] data, int lo, int hi) {
        int lt = lo;
        int i = lo+1;
        int gt = hi;
        int v = data[lo];

        while (i<=gt){
            if (v>data[i])
                SortUtils.swap(data,lo++,i++);
            else if (v<data[i])
                SortUtils.swap(data,gt--,i);
            else
                i++;
        }

        quick3way(data,lo,lt-1);
        quick3way(data,gt+1,hi);
    }
}
