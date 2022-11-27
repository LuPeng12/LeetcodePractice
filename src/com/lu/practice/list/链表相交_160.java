package com.lu.practice.list;

/**
 * @author lup
 * @create 2022/11/27 15:25
 */
public class 链表相交_160 {
    //暴力
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node = null;
        ListNode headb = headB;
        labelA:
        while (headA != null) {
            while (headB != null) {
                if (headA == headB) {
                    node = headA;
                    break labelA;
                }
                headB = headB.next;
            }
            headB = headb;
            headA = headA.next;
        }
        return node;
    }

    //因为相交节点是指这个节点相同，意味着该节点的指向也相同（即后面节点一致），
    // 所以两个链表有相交节点且长度不一时，那么只需要从后面对齐，再判断有无相同节点
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode node = null;

        ListNode cur1 = headA;
        ListNode cur2 = headB;

        int sizeA = 0, sizeB = 0;

        while (headA != null) {
            sizeA++;
            headA = headA.next;
        }

        while (headB != null) {
            sizeB++;
            headB = headB.next;
        }

        if (sizeA > sizeB) {
            int i = sizeA - sizeB;
            for (int j = 0; j < i; j++) {
                cur1 = cur1.next;
            }
            while (cur1 != null) {
                if (cur1 == cur2) {
                    node = cur1;
                    break;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        } else if (sizeA < sizeB) {
            int i = sizeB - sizeA;
            for (int j = 0; j < i; j++) {
                cur2 = cur2.next;
            }
            while (cur1 != null) {
                if (cur1 == cur2) {
                    node = cur1;
                    break;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        } else {
            while (cur1 != null) {
                if (cur1 == cur2) {
                    node = cur1;
                    break;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        return node;
    }


//简略版
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

}
