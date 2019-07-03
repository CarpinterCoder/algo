package com.company.algo.myLeetcode.tree;

import java.util.HashMap;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 17:33 2018/7/17
 */

/**
 * 已知二叉树前序遍历与中序遍历的数组，重建二叉树。假设二叉树中没有值相同的节点
 *
 * 思路：二叉树中序遍历数组的索引在原二叉树中的位置符合二叉排序树的规则：
 *                即左子树节点的索引均小于根节点的索引，根节点索引小于右子树全部节点的索引
 *      记录一个HashMap：键为inorder数组元素，值为其在inorder中相应的索引
 *      将前序遍历数组的第一个元素设为根节点，按照从左到右遍历前序遍历数组，根据节点在中序
 *      遍历数组中索引值的大小按照二叉排序树原则重建二叉树
 *
 * */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null || inorder==null)return null;
        if (preorder.length==0)return null;
//        if (preorder.length==1)return new TreeNode(preorder[0]);
        HashMap<Integer,Integer> indexMap = new HashMap<Integer, Integer>(preorder.length);
        for (int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i=1;i<preorder.length;i++){
            TreeNode curr = root;
            int index = indexMap.get(preorder[i]);
            while (true){
                if (index<indexMap.get(curr.val)){
                    if (curr.left==null){
                        curr.left = new TreeNode(preorder[i]);
                        break;
                    }
                    curr = curr.left;
                }else{
                    if (curr.right==null){
                        curr.right = new TreeNode(preorder[i]);
                        break;
                    }
                    curr = curr.right;
                }
            }
        }
        return root;
    }
}
