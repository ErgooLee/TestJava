package com.xiaowuzei.test.algr.leet;

public class N141_LinkedListCycle {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p1 != null && p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p2 != null && p2 == p1) {
                return true;
            }
        }
        return false;
    }

}
