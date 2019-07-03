package com.company.algo.myLeetcode.tree;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 10:37 2018/7/18
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder==null || postorder==null || inorder.length==0 || postorder.length==0)return null;
        if (inorder.length==1 || postorder.length==1)return new TreeNode(postorder[0]);
        TreeNode root = buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return root;
    }

    private TreeNode buildTree(int[] inorder, int inLo, int inHi, int[] postorder, int poLo, int poHi) {
        if (inLo>inHi || poLo>poHi)return null;
        TreeNode root = new TreeNode(postorder[poHi]);
        if (inLo==inHi || poLo==poHi)return root;
        int rootIndex = 0;
        for (int i=inLo;i<=inHi;i++){
            if (postorder[poHi]==inorder[i]){
                rootIndex = i;
                break;
            }
        }
        int inLoL = inLo;
        int inHiL = rootIndex-1;
        int inLoR = rootIndex+1;
        int inHiR = inHi;

        if (inHiL>=inLoL){
            int poLoL = poLo;
            int poHiL = poLoL+(inHiL-inLoL);
            root.left = buildTree(inorder,inLoL,inHiL,postorder,poLoL,poHiL);
        }
        if (inHiR>=inLoR){
            int poHiR = poHi-1;
            int poLoR = poHiR-(inHiR-inLoR);
            root.right = buildTree(inorder,inLoR,inHiR,postorder,poLoR,poHiR);
        }
        return root;
    }
}
