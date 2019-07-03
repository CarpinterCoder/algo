package com.company.algo.sort.shell;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 13:03 2018/6/9
 */
/**
 * 思想是使数组中任意间隔为h的元素都是有序的，实质是   分组插入排序。
 *
 * 希尔排序：先取一个小于n的整数d1作为第一个增量，
 * 把文件的全部记录分成（n除以d1）个组。所有距离为d1的倍数的记录放在同一个组中。
 * 先在各组内进行直接插入排序；然后，取第二个增量d2<d1重复上述的分组和排序，
 * 直至所取的增量dt=1(dt<dt-l<…<d2<d1)，即所有记录放在同一组中再对全体元素进行一次插入排序。
 *
 * 上面希尔排序的步长选择都是从n/2开始，每次再减半，直到最后为1。其实也可以有另外的更高效的步长选择
 */

public class Shell {
    public void sort(int[] data){
        int N = data.length;
        int h = 1;

        while (h<N/3)
            h = 3*h+1;
        while (h>1){
            for (int i=h;i<data.length;i++){
                for (int j=i;j>=h && data[j]<data[j-h];j-=h){
                    exch(data,j,j-h);
                }
            }
            h /= 3;
        }
    }

    private void exch(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
