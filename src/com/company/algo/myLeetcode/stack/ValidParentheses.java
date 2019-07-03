package com.company.algo.myLeetcode.stack;

import java.util.Stack;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 21:20 2018/7/24
 */
/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 * The brackets must close in the correct order, "()" and "()[]" are all valid but "(]" and "([)]" are
 * not.
 * */
public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s==null || s.length()==0)return true;
        Stack<Character> stack = new Stack<Character>();
        for (int i=0;i<s.length();){
            char c = s.charAt(i);
            if (c=='(' || c=='[' || c=='{'){
                if (i+1<s.length()){
                    String ss = s.substring(i,i+2);
                    if (ss.equals("()") || ss.equals("[]") || ss.equals("{}"))
                        i+=2;
                    else{
                        stack.push(c);
                        i++;
                    }
                }else {
                    return false;
                }
            }else {
                if (!stack.isEmpty()){
                    String ss = stack.pop().toString()+Character.toString(c);
                    if (ss.equals("()") || ss.equals("[]") || ss.equals("{}"))
                        i++;
                    else{
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args){
        String s = "(()[]{[]})";
        System.out.println(isValid(s));
    }
}
