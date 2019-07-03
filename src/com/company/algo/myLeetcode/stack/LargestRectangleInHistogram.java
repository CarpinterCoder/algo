package com.company.algo.myLeetcode.stack;

import java.util.Stack;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 15:43 2018/7/25
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height==null || height.length==0)return 0;
        if (height.length==1)return height[0];
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;

        for (int i=0;i<height.length;){
            if (!stack.isEmpty()){
                int i2 = stack.peek();

                if (height[i]>=height[i2]){
                    stack.push(i++);
                }else {
                    stack.pop();
                    if (!stack.isEmpty()){
                        max = Math.max(max,(i-1-stack.peek())*height[i2]);
                    }else {
                        max = Math.max(max,i*height[i2]);
                    }

                }
            }else {
                stack.push(i++);
            }
        }

        while (!stack.isEmpty()){
            int i=stack.pop();
            if (!stack.isEmpty()){
                max = Math.max(max,(height.length-1-stack.peek())*height[i]);
            }else {
                max = Math.max(max,height.length*height[i]);
            }
        }
        return max;
    }
}
