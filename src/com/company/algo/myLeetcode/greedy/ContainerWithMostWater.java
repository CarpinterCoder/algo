package com.company.algo.myLeetcode.greedy;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 14:30 2018/8/8
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height==null || height.length<2)
            return 0;
        int lo=0, hi=height.length-1;
        int maxArea = 0;
        while (hi>lo){
            maxArea = Math.max(maxArea,(hi-lo)*Math.min(height[hi],height[lo]));
           if (height[lo]<=height[hi]){
               for (int i=lo+1;i<height.length;i++){
                   if (height[i]>height[lo]){
                       lo = i;
                       break;
                   }else if (i==hi){
                       lo = i;
                   }
               }
           }else {
               for (int j=hi-1;j>=0;j--){
                   if (height[j]>height[hi]){
                       hi = j;
                       break;
                   }else if (j==lo){
                       hi = j;
                   }
               }
           }
        }
        return maxArea;
    }
}
