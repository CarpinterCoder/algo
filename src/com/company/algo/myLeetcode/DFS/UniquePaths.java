package com.company.algo.myLeetcode.DFS;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 15:05 2018/8/12
 */
/**
 * 深度搜索：小集可通过，大集超时
 */
@Deprecated
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m<=0 || n<=0)
            return 0;

        int x=1,y=1;
        int res = nextStep(x,y,m,n);
        return res;
    }

    private int nextStep(int x, int y, int m, int n) {
        if (x>m || y>n)
            return 0;

        if (x==m && y==n)
            return 1;

        return nextStep(x+1,y,m,n)+nextStep(x,y+1,m,n);
    }
}
