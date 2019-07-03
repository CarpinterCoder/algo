package com.company.algo.sort.merge;

/**
 * @Description: 自底向上归并排序
 * @Author:XiaoNing
 * @Date:Greated in 15:20 2018/6/9
 */
public class Merge2 {
    private int[] aux;

    public void sort(int[] data){
        int N = data.length;
        aux = new int[N];
        for (int sz = 1;sz<N;sz*=2){
            for (int lo=0;lo<N-2*sz;lo+=(2*sz)){
                merge(data,lo,lo+sz-1,Math.min(N-1,lo+2*sz-1));
            }
        }
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
