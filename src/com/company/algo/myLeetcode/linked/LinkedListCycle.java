package com.company.algo.myLeetcode.linked;

/**
 * @Description: ***
 * @Author:XiaoNing
 * @Date:Greated in 15:09 2018/8/1
 */
/**
 * 检验链表是否存在环
 * 要求：空间复杂度O(1)
 * 思路：
 *      设置两个指针：快指针、慢指针；快指针每次循环走2步，慢指针每次循环走1步
 *                  当快指针为null，则不存在链表环
 *                  当快指针与慢指针相遇，则存在链表环
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head==null)return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
            if (fast==null)
                break;
            fast = fast.next;
            if (fast==slow)
                return true;
        }

        return false;
    }
}
