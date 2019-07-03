package com.company.algo.myLeetcode.tree;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 11:14 2018/7/18
 */
/**
 *
 * */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        for (int i=2;i<=n;i++){
            //计算f(i)
            f[i]=0;
            for (int k=1;k<=i;k++){
                //以k为根节点
                f[i]+=f[k-1]*f[i-k];
            }
        }
        return f[n];
    }
}
