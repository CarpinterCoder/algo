package com.company.algo.myLeetcode.linked;

/**
 * @Description: ***
 * @Author:XiaoNing
 * @Date:Greated in 14:27 2018/8/1
 */
/**
 * A linked list is given such that each node contains an additional random pointer which could point to
 * any node in the list or null.
 * Return a deep copy of the list.
 *
 * */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null)return null;
        RandomListNode cur = head;
        while (cur!=null){
            RandomListNode next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        while (cur!=null){
            RandomListNode copy = cur.next;
            if (cur.random!=null)
                copy.random = cur.random.next;
            cur = cur.next.next;
            if (cur!=null)
                copy.next = cur.next;
        }
        return head.next;
    }
}
