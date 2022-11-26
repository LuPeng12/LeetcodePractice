package com.lu.practice.list;

import java.util.List;

/**
 * @Author lupeng
 * @Date 2022/9/24
 */
public class 反转链表_206 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6))))));
        ListNode nodere = reverse(node1);
        ListNode nodeReverseN = reverse2(node1);
       while (nodere!=null){
           System.out.println(nodere.val);
           nodere = nodere.next;
       }
    }

    private static ListNode reverse(ListNode node1) {
        ListNode story = new ListNode();
        if (node1 != null||node1.next == null){
            return node1;
        }
       ListNode li = reverse(node1.next);
        node1.next.next = node1;
        node1.next = null;
        return li;
    }
    private static ListNode reverse2(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
