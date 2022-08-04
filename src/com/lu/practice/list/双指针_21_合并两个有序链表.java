package com.lu.practice.list;

/**
 * @Author lupeng
 * @Date 2022/8/4
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class 双指针_21_合并两个有序链表 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;

        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
      ListNode node1 = new ListNode(1,new ListNode(2,new ListNode(4)));
      ListNode node2 = new ListNode(1,new ListNode(3,new ListNode(4)));
      ListNode result = mergeTwoLists(node1,node2);
      while (result != null){
          System.out.println(result.val+"->");
          result = result.next;
      }
    }
}



   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }