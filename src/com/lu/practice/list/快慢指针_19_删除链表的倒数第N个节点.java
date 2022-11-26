package com.lu.practice.list;

/**
 * @Author lupeng
 * @Date 2022/8/5
 * 倒数第k = n-k+1
 * 先走k 剩n-k
 */
public class 快慢指针_19_删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumy = new ListNode(-1);
        dumy.next = head;

         ListNode p1 = head;
         ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1 != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        p2.next = p2.next.next;

        return dumy.next;
    }
}
