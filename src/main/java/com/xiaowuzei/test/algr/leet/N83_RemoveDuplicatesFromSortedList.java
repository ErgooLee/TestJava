package com.xiaowuzei.test.algr.leet;

public class N83_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        System.out.println(new N83_RemoveDuplicatesFromSortedList().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, null)))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head.next;
        ListNode tail = head;
        while (p != null) {
            if (p.val != tail.val) {
                tail.next = p;
                tail = p;
            }
            p = p.next;
        }
        tail.next = null;
        return head;
    }

}
