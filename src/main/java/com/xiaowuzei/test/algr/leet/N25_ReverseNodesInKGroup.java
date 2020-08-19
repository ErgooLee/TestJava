package com.xiaowuzei.test.algr.leet;

import java.util.Stack;

public class N25_ReverseNodesInKGroup {

    public static void main(String[] args) {
        System.out.println(new N25_ReverseNodesInKGroup().reverseKGroup(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, new ListNode(6, new ListNode(7, null))))))), 4));

        System.out.println(new N25_ReverseNodesInKGroup().reverseKGroup(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, new ListNode(6, new ListNode(7, null))))))), 2));

        System.out.println(new N25_ReverseNodesInKGroup().reverseKGroup(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, new ListNode(6, new ListNode(7, null))))))), 1));

        System.out.println(new N25_ReverseNodesInKGroup().reverseKGroup(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, new ListNode(6, new ListNode(7, null))))))), 7));

        System.out.println(new N25_ReverseNodesInKGroup().reverseKGroup(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, null))))), 3));

        System.out.println(new N25_ReverseNodesInKGroup().reverseKGroup(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3, null))), 2));

        System.out.println(new N25_ReverseNodesInKGroup().reverseKGroup(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3, null))), 1));

        System.out.println(new N25_ReverseNodesInKGroup().reverseKGroup(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3, null))), 4));
    }

    int initK;
    ListNode inter;

    public ListNode reverseKGroup2(ListNode head, int k) {
        initK = k;
        return reverse(head, initK);
    }

    public ListNode reverse(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        if (k == 1) {
            inter = head.next;
            return head;
        } else {
            ListNode last = reverse(head.next, k - 1);
            head.next.next = head;
            if (k == initK && !head.equals(inter)) {
                head.next = reverse(inter, initK);
            } else {
                head.next = null;
            }
            return last;
        }
    }


    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode newHead = null;
        ListNode tail = null;
        ListNode p = head;
        ListNode p2;
        Stack<ListNode> nodes = new Stack<>();
        int count = 0;
        while (p != null || count == k) {
            if (count == k) {
                while (!nodes.isEmpty()) {
                    p2 = nodes.pop();
                    if (tail == null) {
                        newHead = p2;
                    } else {
                        tail.next = p2;
                    }
                    tail = p2;
                }
                count = 0;
            } else {
                p2 = p;
                p = p.next;
                p2.next = null;
                nodes.add(p2);
                count++;
            }
        }

        head = null;
        while (!nodes.isEmpty()) {
            p = nodes.pop();
            p.next = head;
            head = p;
        }
        if (tail != null) {
            tail.next = head;
        } else {
            return head;
        }
        return newHead;
    }


    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, nxt;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(head, b);
        head.next = reverseKGroup(b, k);
        return newHead;
    }


}
