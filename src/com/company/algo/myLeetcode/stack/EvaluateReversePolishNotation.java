package com.company.algo.myLeetcode.stack;

import java.util.Stack;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 21:15 2018/7/25
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens==null || tokens.length==0)return 0;
        if (tokens.length==1)
            return Integer.valueOf(tokens[0]);
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0;i<tokens.length;i++){
            if (!(tokens[i].equals("+") || tokens[i].equals("-")
                    || tokens[i].equals("*") || tokens[i].equals("/"))){
                stack.push(Integer.valueOf(tokens[i]));
            }else {
                if (tokens[i].equals("+")){
                    int left = stack.pop();
                    int right = stack.pop();
                    stack.push(left+right);
                }else if (tokens[i].equals("-")){
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left-right);
                }else if (tokens[i].equals("*")){
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left*right);
                }else if (tokens[i].equals("/")){
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left/right);
                }
            }
        }
        return stack.pop();
    }
}
