package com.lu.practice.list;

/**
 * @author lup
 * @create 2022/11/26 15:23
 */
public class 基础操作_707_设计链表 {
   int size;

    /**
     * 虚拟头节点
     */
    ListNode head;

    public 基础操作_707_设计链表(){
          size = 0;
          head = new ListNode(0);
    }

    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode currentNode = head;
        while (index >= 0){
            currentNode = currentNode.next;
            index--;
        }
        return currentNode.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode node = new ListNode(val);
        ListNode currentNode = head;
        while (index > 0){
            currentNode = currentNode.next;
            index--;
        }
        node.next = currentNode.next;
        currentNode.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode currentNode = head;
        while (index > 0){
            currentNode = currentNode.next;
            index--;
        }
        currentNode.next = currentNode.next.next;
        size--;
    }
}
