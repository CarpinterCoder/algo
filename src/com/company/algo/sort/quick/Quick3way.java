package com.company.algo.sort.quick;

/**
 * <p>
 *     定义  序列中所有主键的香农信息量
 *              设包含k个不同值的N个主键，pi为第i个主键出现的概率，则所有主键出现的香农信息量为：
 *                                   H = -(p1lgp1+p2lgp2+...+pklgpk)
 *              当所有主键值均不重复时，有
 *                                              H = lgN
 *
 *     A、不存在任何基于比较的排序算法能够保证在NH-H次比较内将N个元素排序
 *
 *
 *     三向切分快速排序
 *          1、原地排序算法
 *          2、比较次数：~(2ln2)NH
 *
 *     基本思想
 *          由于快速排序中切分之后将确定某一元素的位置，则与该元素值相等的元素的位置也随之确定；
 *          若用普通的快速排序算法，将对所有重复元素进行同样的切分操作，为了避免重复的操作，采用三向切分快速排序算法
 *
 *     原理
 *          设数组a的子数组从索引lo开始到索引hi结束，维护三个指针lt、i、gt，使得：
 *                              a[lo,...,lt-1]中的所有元素小于v
 *                              a[lt,...,i-1]中的所有元素等于v
 *                              a[i,...,gt]中的元素待排序
 *                              a[gt+1,...,hi]中的所有元素大于v
 *
 *     应用场景
 *              适用于存在大量重复元素的序列中，最坏的应用场景为所有主键均不同
 *              所有主键均不同时，普通快速排序优于三向切分快速排序
 *
 * </p>
 * @Author:XiaoNing
 * @Date:Greated in 13:52 2018/6/10
 */
public class Quick3way {
    public void sort(int[] data){
        sort(data,0,data.length-1);
    }

    private void sort(int[] data, int lo, int hi) {
        if (lo>=hi)
            return;

        int lt = lo;
        int i = lo+1;
        int gt = hi;
        int v = data[lo];
        while (i<=gt){
            if (data[i]<v)
                exch(data,i++,lt++);
            else if (data[i]>v)
                exch(data,i,gt--);
            else
                i++;
        }

        sort(data,lo,lt-1);
        sort(data,gt+1,hi);
    }

    private void exch(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
