package com.lu.practice.list;

/**
 * @Author lupeng
 * @Date 2022/8/4
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class 双指针_86_分隔链表 {
    public static ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(-1), p1 = res;
        ListNode res2 = new ListNode(-1),p2 = res2;
        ListNode p = head;
        while (p != null){
            if (p.val < x){
                p1.next = p;
                p1 = p1.next;
            }else {
              p2.next = p;
              p2 = p2.next;
            }
            //断开原链表的next节点
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = res2.next;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2))))));
        ListNode result = partition(node1,3);
        while (result != null){
            System.out.println(result.val+"->");
            result = result.next;
        }
    }
}
