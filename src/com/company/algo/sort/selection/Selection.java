package com.company.algo.sort.selection;

/**
 * <p>
 *      选择排序
 *           1、原地排序算法(原地排序算法：除了函数调用所需的栈和固定数目的实例之外无需额外的内存)
 *           2、比较次数：(N^2)/2；  交换次数：[0,(N^2)/2]
 *           3、运行时间：O(N^2)
 *  </p>
 * @Description: 选择排序
 * @Author:XiaoNing
 * @Date:Greated in 11:46 2018/6/9
 */
public class Selection {
    public void sort(int[] data){
        for (int i=0;i<data.length;i++){
            for (int j=i+1;j<data.length;j++){
                if (data[i]>data[j])
                    exch(data,i,j);
            }
        }
    }

    private void exch(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
