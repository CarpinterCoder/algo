package com.company.algo.myLeetcode.tree;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 21:32 2018/7/17
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0)return null;
        if (preorder.length==1)return new TreeNode(preorder[0]);
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int preLo, int preHi, int[] inorder, int inLo, int inHi) {
        if (inHi<inLo || preHi<preLo)return null;
        TreeNode root = new TreeNode(preorder[preLo]);
        if (inHi==inLo || preHi==preLo)return root;
        int rootIndex = 0;
        for (int i=inLo;i<=inHi;i++){
            if (preorder[preLo]==inorder[i]){
                rootIndex = i;
                break;
            }
        }
        int inLoL = inLo;
        int inHiL = rootIndex-1;
        int preLoL = preLo+1;
        int preHiL = preLoL+(inHiL-inLo);

        int inLoR = rootIndex+1;
        int inHiR = inHi;
        int preLoR = preHiL+1;
        int preHiR = preHi;
        root.left = buildTree(preorder,preLoL,preHiL,inorder,inLoL,inHiL);
        root.right = buildTree(preorder,preLoR,preHiR,inorder,inLoR,inHiR);
        return root;
    }
}
