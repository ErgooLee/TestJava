package com.xiaowuzei.test.algr.leet;

public class N206_ReverseLinkedList {

    public static void main(String[] args) {
        System.out.println(new N206_ReverseLinkedList().reverse(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, null)))))));

    }

    public ListNode reverseLst(ListNode head) {
        ListNode newHead = null;
        ListNode p = head;
        ListNode tmp;
        while (p != null) {
            tmp = p.next;
            p.next = newHead;
            newHead = p;
            p = tmp;
        }
        return newHead;
    }

    //有点儿巧妙的
    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
