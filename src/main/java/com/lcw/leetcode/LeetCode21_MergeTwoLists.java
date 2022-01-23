package com.lcw.leetcode;

/**
 * @description 描述
 * @outhor Lu Congwen
 * @create 2022-01-04 19:54
 */
public class LeetCode21_MergeTwoLists {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // special situations
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 != null && list2 == null) {
            return list1;
        }
        if (list1 == null && list2 != null) {
            return list2;
        }
        // 2 points, add smaller one to list
        ListNode firstP = list1, secondP = list2;
        ListNode head = new ListNode();
        ListNode temp = head;
        if (firstP.next == null && secondP.next == null) {
            if (firstP.val <= secondP.val) {
                firstP.next = secondP;
                return firstP;
            }
            secondP.next = firstP;
            return secondP;
        }
        while (firstP != null && secondP != null) {
            if (firstP.val <= secondP.val) {
                temp.next = firstP;
                firstP = firstP.next;
            } else {
                temp.next = secondP;
                secondP = secondP.next;
            }
            temp = temp.next;
        }
        // add last list
        if (firstP == null) {
            temp.next = secondP;
        } else {
            temp.next = firstP;
        }
        return head.next;
    }
}
