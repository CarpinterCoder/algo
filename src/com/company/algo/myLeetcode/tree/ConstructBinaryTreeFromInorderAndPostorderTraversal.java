package com.company.algo.myLeetcode.tree;

import java.util.HashMap;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 21:03 2018/7/17
 */

/**
 * 已知二叉树的中序遍历及后续遍历数组，重建二叉树。假设二叉树中不存在值相等的节点
 *
 * 思路：二叉树中序遍历数组的索引在原二叉树中的位置符合二叉排序树的规则：
 *                即左子树节点的索引均小于根节点的索引，根节点索引小于右子树全部节点的索引
 *      记录一个HashMap：键为inorder数组元素，值为其在inorder中相应的索引
 *      将前序遍历数组的最后一个元素设为根节点，按照从右到左遍历前序遍历数组，根据节点在中序
 *      遍历数组中索引值的大小按照二叉排序树原则重建二叉树
 *
 * */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder==null || postorder==null || inorder.length==0)return null;
        int len = inorder.length;
        TreeNode root = new TreeNode(postorder[len-1]);
        HashMap<Integer,Integer> indexMap = new HashMap<Integer, Integer>(inorder.length);
        for (int i=0;i<inorder.length;i++)
            indexMap.put(inorder[i],i);
        for (int i=postorder.length-2;i>=0;i--){
            TreeNode curr = root;
            int index = indexMap.get(postorder[i]);
            while (true){
                int currIndex = indexMap.get(curr.val);
                if (index<currIndex){
                    if (curr.left==null){
                        curr.left = new TreeNode(postorder[i]);
                        break;
                    }
                    curr = curr.left;
                }else {
                        if (curr.right==null){
                            curr.right = new TreeNode(postorder[i]);
                            break;
                        }
                    curr = curr.right;
                }
            }
        }
        return root;

    }
}
