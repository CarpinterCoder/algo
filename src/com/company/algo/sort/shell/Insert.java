package com.company.algo.sort.shell;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 12:50 2018/6/9
 */
public class Insert {
    public void sort(int[] data){
        for (int i=1;i<data.length;i++){
            for (int j=i;j>0 && data[j]<data[j-1];j--){
                exch(data,j,j-1);
            }
        }
    }

    private void exch(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
