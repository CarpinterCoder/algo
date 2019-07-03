package com.company.algo.myLeetcode.tree;

import java.util.ArrayList;


/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 12:59 2018/7/18
 */
public class UniqueBinarySearchTreesII {
    public ArrayList<TreeNode> generateTrees(int n) {
        if (n==0){
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            list.add(null);
            return list;
        }
        ArrayList<TreeNode> list = generateTrees(1,n);
        return list;
    }

    private ArrayList<TreeNode> generateTrees(int lo, int hi) {
        if (lo>hi)return null;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        if (lo==hi){
            list.add(new TreeNode(lo));
            return list;
        }
        for (int k=lo;k<=hi;k++){
            ArrayList<TreeNode> leftTrees = generateTrees(lo,k-1);
            ArrayList<TreeNode> rightTrees = generateTrees(k+1,hi);
            if (leftTrees==null){
                for (TreeNode treeNode:rightTrees){
                    TreeNode root = new TreeNode(k);
                    root.right = treeNode;
                    list.add(root);
                }
            }
            if (rightTrees==null){
                for (TreeNode treeNode:leftTrees){
                    TreeNode root = new TreeNode(k);
                    root.left = treeNode;
                    list.add(root);
                }
            }

            if (leftTrees!=null && rightTrees!=null){
                for (TreeNode leftNode:leftTrees){
                    for (TreeNode rightNode:rightTrees){
                        TreeNode root = new TreeNode(k);
                        root.left = leftNode;
                        root.right = rightNode;
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }
}
