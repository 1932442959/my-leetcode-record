package com.lcw.leetcode;

import java.util.List;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LeetCode19_RemoveNthFromEnd {

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // list's length is 1 and n = 1 , after delete, list will be null
        if (head.next == null && n == 1) {
            return null;
        }
        // two points, the gap is n
        ListNode firstP = head, secondP = head;
        for (int i = 0; i < n; i++) {
            secondP = secondP.next;
        }
        // secondP is null, so list's length is n, delete first node
        if (secondP == null) {
            head = head.next;
            return head;
        }
        // when secondP arrive to the last node, execute delete operation
        while (secondP.next != null) {
            firstP = firstP.next;
            secondP = secondP.next;
        }
        // when n = 1, delete last node
        if (n == 1) {
            firstP.next = null;
            return head;
        }
        // when n > 1, delete and set next
        firstP.next = firstP.next.next;
        return head;
    }
}

