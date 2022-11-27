package com.lu.practice.list;

/**
 * @author lup
 * @create 2022/11/27 13:51
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class 基础操作_24_两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;


        while (prev.next != null && prev.next.next != null){
            ListNode temp = head.next.next;

            prev.next = head.next;
            head.next.next = head;
            head.next = temp;

            prev = head;
            head = head.next;
        }
    return dummyNode.next;
    }

    // 递归版本
    public ListNode swapPairs2(ListNode head) {
        // base case 退出提交
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }
}
