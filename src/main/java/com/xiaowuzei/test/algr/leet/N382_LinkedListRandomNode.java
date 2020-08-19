package com.xiaowuzei.test.algr.leet;

import java.util.Random;

public class N382_LinkedListRandomNode {

    public static void main(String[] args) {

    }

    ListNode head;

    public N382_LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        Random random = new Random();
        int result = 0;
        ListNode p = head;
        int i = 0;
        while (p != null) {
            if (random.nextInt(++i) == 0) {
                result = p.val;
            }
            p = p.next;
        }
        return result;
    }


}
