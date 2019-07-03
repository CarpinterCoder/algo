package com.company.algo.myLeetcode.sort.basic;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 15:59 2018/7/23
 */
public class SelectionSort {
    public void sort(int[] data){
        for (int i=0;i<data.length-1;i++){
            for(int j =i+1;j<data.length;j++){
                if (data[j]<data[i])
                    SortUtils.swap(data,i,j);
            }
        }
    }
}
