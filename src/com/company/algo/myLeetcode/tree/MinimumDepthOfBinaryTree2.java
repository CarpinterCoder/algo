package com.company.algo.myLeetcode.tree;

import java.util.LinkedList;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 20:20 2018/7/18
 */
public class MinimumDepthOfBinaryTree2 {
    public int run(TreeNode root) {
        if (root==null)return 0;
        int dep = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addFirst(root);
        int m=1;
        while (true){
            dep+=1;
            int n=m;
            m=0;
            for (int i=1;i<=n;i++){
                TreeNode node = queue.pollLast();
                if (node.left==null && node.right==null)return dep;
                if (node.left!=null){
                    queue.addFirst(node.left);
                    m+=1;
                }
                if (node.right!=null){
                    queue.addFirst(node.right);
                    m+=1;
                }
            }
        }
    }
}
