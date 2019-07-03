package com.company.algo.myLeetcode.force;

import java.util.ArrayList;

/**
 * @Description: *****
 * @Author:XiaoNing
 * @Date:Greated in 22:14 2018/8/9
 */
/**
 * Given a collection of numbers, return all possible permutations.
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1],
 * [3,1,2], and [3,2,1].
 *
 * */
public class Permutations {
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num==null || num.length==0)
            return res;
        int n = num.length;
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        for (int i=0;i<n;i++)
            list.add(num[i]);
        res.add(list);
        int count = 1;
        while (n>1){
            count*=n;
            n--;
        }
        for (int i=1;i<count;i++){
            ArrayList<Integer> permunation = nextPermutation(num);
            res.add(permunation);
        }
        return res;
    }

    private static ArrayList<Integer> nextPermutation(int[] num) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (num==null || num.length==0)
            return res;
        for (int i=num.length-2;i>=0;i--) {
            if (num[i] < num[i + 1]) {
                for (int j = num.length - 1; j >= i + 1; j--) {
                    if (num[j] > num[i]) {
                        exch(num, i, j);
                        break;
                    }
                }
                int lo = i + 1, hi = num.length - 1;
                while (hi > lo) {
                    exch(num, lo++, hi--);
                }
                break;
            } else if (i == 0) {
                int lo = 0, hi = num.length - 1;
                while (hi > lo) {
                    exch(num, lo++, hi--);
                }
                break;
            }
        }
        for (int i=0;i<num.length;i++)
            res.add(num[i]);

        return res;
    }

    private static void exch(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        System.out.println(permute(arr));
    }


}
