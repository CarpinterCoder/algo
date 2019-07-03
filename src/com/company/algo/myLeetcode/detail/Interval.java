package com.company.algo.myLeetcode.detail;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 19:32 2018/8/27
 */
public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
