package com.lu.practice.list;

import jdk.internal.org.objectweb.asm.tree.LdcInsnNode;

/**
 * @author lup
 * @create 2022/11/26 14:27
 * 删除链表中等于给定值 val 的所有节点。
 */
public class 基础操作_203_移除链表元素 {

    public static ListNode removeElements(ListNode head, int val) {
        if (head==null){
            return null;
        }
       //虚拟头节点
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;

          while (cur != null){
              if (cur.val == val){
                  pre.next = cur.next;
              }else {
                  pre = cur;
              }
              cur = cur.next;
          }
          return dummy.next;

//使用虚拟头节点情况
//        while(head!=null && head.val==val){
//            head = head.next;
//        }
//        ListNode curr = head;
//        while(curr!=null){
//            while(curr.next!=null && curr.next.val == val){
//                curr.next = curr.next.next;
//            }
//            curr = curr.next;
//        }
//        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(6,new ListNode(3,new ListNode(4,new ListNode(6))))));
        ListNode result = removeElements(head,6);
        while (result != null){
            System.out.println(result.val+"->");
            result = result.next;
        }
    }
}
