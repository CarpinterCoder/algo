package com.company.algo.myLeetcode.sort;

/**
 * @Description: ***
 * @Author:XiaoNing
 * @Date:Greated in 17:08 2018/7/24
 */
/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are
 * adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library’s sort function for this problem.
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0’s, 1’s, and 2’s, then overwrite array with total number of 0’s,
 * then 1’s and followed by 2’s.
 * Could you come up with an one-pass algorithm using only constant space?
 *
 */
public class SortColors {
    public void sortColors(int[] nums) {
        // write your code here
        if (nums==null || nums.length<2)
            return;

        int lt = -1,gt = nums.length-1,i = 0;
        while (nums[i]!=1){
            if (nums[i]==0){
                i++;
            }else {
                exch(nums,i,gt--);
            }
        }

        lt = i;i = lt+1;
        while (i<=gt){
            if (nums[i]==1) i++;
            else if (nums[i]<1) exch(nums,lt++,i++);
            else exch(nums,i,gt--);
        }


    }

    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
