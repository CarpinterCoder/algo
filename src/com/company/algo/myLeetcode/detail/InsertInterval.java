package com.company.algo.myLeetcode.detail;

import java.util.ArrayList;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 19:32 2018/8/27
 */
public class InsertInterval {
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (intervals==null || intervals.size()==0){
            ArrayList<Interval> res = new ArrayList<Interval>();
            res.add(newInterval);
            return res;
        }

        if (newInterval.start>intervals.get(intervals.size()-1).end){
            intervals.add(newInterval);
            return intervals;
        }

        if (newInterval.end<intervals.get(0).start){
            intervals.add(0,newInterval);
            return intervals;
        }

        if (intervals.size()==1){
            intervals.get(0).start = Math.min(intervals.get(0).start,newInterval.start);
            intervals.get(0).end = Math.max(intervals.get(0).end,newInterval.end);
            return intervals;
        }
        int lo = 0,hi = intervals.size()-1;
        int startIndex=-1;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            if (newInterval.start>intervals.get(mid).start){
                lo = mid+1;
            }else if (newInterval.start<intervals.get(mid).start){
                hi = mid-1;
            }else {
                startIndex=mid;
                break;
            }
        }
        if (startIndex==-1){
            if (hi>=0 && newInterval.start<intervals.get(hi).start){
                startIndex = hi;
            }else {
                startIndex = hi;
                if (hi==-1 || newInterval.start>intervals.get(startIndex).end){
                    startIndex++;
                }else{
                    newInterval.start = intervals.get(startIndex).start;
                }
            }
        }

        int endIndex=-1;
        lo=0;hi=intervals.size()-1;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            if (newInterval.end>intervals.get(mid).end){
                lo = mid+1;
            }else if (newInterval.end<intervals.get(mid).end){
                hi = mid-1;
            }else {
                endIndex = mid;
                break;
            }
        }
        if (endIndex==-1){
            if (hi==intervals.size()-1){
                endIndex = hi;
                newInterval.end = Math.max(newInterval.end,intervals.get(endIndex).end);
            }else {
                if (newInterval.end<intervals.get(hi+1).start){
                    endIndex = hi;
                }else {
                    endIndex = hi+1;
                    newInterval.end = intervals.get(endIndex).end;
                }

            }
        }


        for (int num = endIndex-startIndex+1;num>0;num--){
            intervals.remove(startIndex);
        }
        intervals.add(startIndex,newInterval);

        return intervals;
    }
    public static void main(String[] args){
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1,5));
        intervals.add(new Interval(6,8));
        intervals = insert(intervals,new Interval(0,9));
        for (Interval interval:intervals){
            System.out.println(interval);
        }
    }
}
