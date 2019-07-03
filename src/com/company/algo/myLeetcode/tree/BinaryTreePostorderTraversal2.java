package com.company.algo.myLeetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 21:38 2018/7/10
 */
/**
 * 二叉树后序遍历
 * 非递归法
 *
 * */
public class BinaryTreePostorderTraversal2 {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        Stack<TreeNode> mids = new Stack<TreeNode>();
        while (node!=null || !stack.isEmpty() || !mids.isEmpty()){
            if (node!=null){
                stack.push(node);
                node = node.left;
            }else {
                if (!stack.isEmpty()){
                    if (mids.contains(stack.peek().left)) {
                        if (mids.peek().equals(stack.peek().left))
                            list.add(mids.pop().val);
                        else{
                            list.add(mids.pop().val);
                            continue;
                        }

                    }
                    if ((node=stack.peek().right)==null){
                        list.add(stack.pop().val);
                    }else {
                        mids.push(stack.pop());
                        stack.push(node);
                        node = node.left;
                    }
                }
                if (!mids.isEmpty() && !stack.contains(mids.peek().right)){
                    list.add(mids.pop().val);
                }
            }
        }
        return list;
    }
}
