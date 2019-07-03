package com.company.algo.myLeetcode.stack;

import java.util.Stack;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 22:48 2018/7/24
 */

/**
 *  Given a string containing just the characters '(' and ')', find the length of the
 *  longest valid (wellformed) parentheses substring.
 *  For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *  Another example is ")()())", where the longest valid parentheses substring is "()()",
 *  which has length = 4.
 *
 *  思路：设置几个变量：
 *                flag(boolean)
 *                        当以s.charAt(i)为最后一个元素的字符串是有效的，flag=true
 *                        当以s.charAt(i)为最后一个元素的字符串是无效的，flag=false
 *                maxLens(int[])
 *                        1、maxLens[0]=0
 *                        2、若以s.charAt(i)为最后一个元素的字符串是有效的，maxLens[i]=对应有效字符串长度
 *                        3、若以s.charAt(i)为最后一个元素的字符串是无效的，以s.charAt(i-1)为最后一个元素
 *                           的字符串是有效的，则maxLens[i]=maxLens[i-1]
 *                        4、若以s.charAt(i)为最后一个元素的字符串是无效的，以s.charAt(i-1)为最后一个元素
 *                           的字符串是无效的，则maxLens[i]=0
 *
 *                取maxLens数组中的最大值为最长有效字符串
 *
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()<=1)return 0;
        int[] maxLens = new int[s.length()];
        /*flag==true：说明以s.charAt(i-1)为最后一个元素
        的字符串是有效的，反之则是无效的*/
        boolean flag = false;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i=0;i<maxLens.length;i++){
            char c = s.charAt(i);
            if (c=='(' || c=='[' || c=='{'){
                //将索引入栈，这里既可以通过索引找到相应元素，又可以通过索引得到字符串长度信息
                stack.push(i);
                if (flag){
                    maxLens[i] = maxLens[i-1];
                    flag = false;
                }else {
                    maxLens[i] = 0;
                }
            }else{
                if (!stack.isEmpty()){
                    int i2 = stack.pop();
                    String ss =Character.toString(s.charAt(i2))+Character.toString(c);
                    if (ss.equals("()") || ss.equals("[]") || ss.equals("{}")){
                        maxLens[i] = i-i2+1+maxLens[i2];
                        flag = true;
                    }else {
                        maxLens[i]=0;
                        flag = false;
                        stack.clear();
                    }
                }else {
                    maxLens[i] = 0;
                    flag = false;
                }
            }
        }
        int len = maxLens[0];
        for (int i=1;i<maxLens.length;i++){
            len = maxLens[i]>len?maxLens[i]:len;
        }
        return len;
    }
}
