package com.company.algo.sort.bubble;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 11:25 2018/6/9
 */
public class Bubble {
    public void sort(int[] data){
        boolean flag = true;
        for (int i=0;i<data.length;i++){
            for (int j=0;j<data.length-1-i;j++){
                if (data[j]>data[j+1]){
                    exch(data,j,j+1);
                    flag = false;
                }
            }
            if (flag)
                break;
        }
    }

    private void exch(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
