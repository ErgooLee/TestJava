package com.xiaowuzei.test.algr.leet;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    ListNode() {
    }

    @Override
    public String toString() {
        ListNode p = this;
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            sb.append(p.val);
            if (p.next != null) {
                sb.append("->");
            }
            p = p.next;
        }
        return sb.toString();
    }
}
