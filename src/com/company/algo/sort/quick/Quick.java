package com.company.algo.sort.quick;

/**
 * @Description: 快速排序
 * @Author:XiaoNing
 * @Date:Greated in 14:02 2018/6/9
 */

/** 分治思想：
1．先从数列中取出一个作为基准。
2．分区过程，将比这个数大的全放到它 右边，将比这个数大的全放到它左边。
3．再对左右区间重复第二步，直到各只有一个数。
 *
 * 快速排序：
 1选定第一个元素作为切分元素，然后从数组的左端开始向右扫描直到找到一个大于等于它的元素1，
 2再从数组的右端开始向左扫描直到找到一个小于等于它的元素2，
 3交换这两个元素。
 4重复23，直到左右两个指针相遇，最后交换切分元素和左字数组最右侧元素，即第一次切分元素被排定好位置。
 */
public class Quick {
    public void sort(int[] data){
        sort(data,0,data.length-1);
    }

    private void sort(int[] data, int lo, int hi) {
        if(lo>=hi)return;
        int j = partition(data,lo,hi);
        sort(data,lo,j-1);
        sort(data,j+1,hi);
    }

    //切分：将小于data[lo]的元素全部放在它左边，大于data[lo]的元素全部放在它右边，返回它的索引
    private int partition(int[] data, int lo, int hi) {
        int i=lo,j = hi+1;
        int v = data[lo];
        while (true){
            while (data[++i]<v){
                if (i==hi)
                    break;
            }
            while (data[--j]>v){
                if (j==lo)
                    break;
            }
            if (i>=j)
                break;
            exch(data,i,j);
        }
        exch(data,lo,j);
        return j;
    }

    private void exch(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
