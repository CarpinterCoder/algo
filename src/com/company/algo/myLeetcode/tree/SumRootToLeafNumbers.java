package com.company.algo.myLeetcode.tree;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 15:53 2018/7/19
 */
public class SumRootToLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        getNumber(root,0);
        return sum;
    }

    private void getNumber(TreeNode root,int num) {
        if (root==null)return;
        num = 10*num+root.val;
        if (root.left==null && root.right==null)
            sum+=num;
        if (root.left!=null)
            getNumber(root.left,num);
        if (root.right!=null)
            getNumber(root.right,num);
    }
}
