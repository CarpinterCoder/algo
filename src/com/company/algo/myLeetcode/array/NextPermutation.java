package com.company.algo.myLeetcode.array;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 19:52 2018/7/29
 */
/**
 * 输入一个全排列数组，求其下一个全排列
 *
 *  要求：只在本地作元素交换，不使用额外的内存空间
 *
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if(num==null || num.length<=1)return;
        int i=num.length-1;
        while (i>0 && num[i]<=num[i-1])
            i--;
        if (i>0){
            i--;
            int j = num.length-1;
            while (j>0 && num[j]<=num[i])
                j--;
            exch(num,i,j);
            i++;
        }

        for (int j=num.length-1;i<j;i++,j--)
            exch(num,i,j);

    }

    public void exch(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
