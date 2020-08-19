package com.xiaowuzei.test.algr.leet;

public class N21_MergeTwoSortedLists {
    public static void main(String[] args) {
        System.out.println(new N21_MergeTwoSortedLists().mergeTwoLists(
                new ListNode(1, new ListNode(2, new ListNode(4, null)))
                , new ListNode(1, new ListNode(3, new ListNode(4, null)))));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        int val1, val2;
        while (l1 != null && l2 != null) {
            val1 = l1.val;
            val2 = l2.val;
            if (val1 < val2) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else if (val1 > val2) {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            } else {
                tail.next = l1;
                l1 = l1.next;
                tail.next.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            tail.next = l2;
        } else {
            tail.next = l1;
        }
        return newHead.next;
    }
}
