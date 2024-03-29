package com.lu.practice.list;

import java.util.PriorityQueue;

/**
 * @Author lupeng
 * @Date 2022/8/5
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * （将所有链表先加入到一个优先队列中，，相当于其是一个最小堆，最小的出队后将它的下一个节点插入队列中继续比较）
 *
 */
public class 优先队列_23_合并k个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dumy = new ListNode(-1);
        ListNode p = dumy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {        //依次将头节点后的节点放入堆中排序，之后遍历拼接
                pq.add(node.next);
            }
            p = p.next;
        }
        return dumy.next;
    }
}
