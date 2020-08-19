package com.xiaowuzei.test.algr.leet;

public class N160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1 = getLength(headA);
        int length2 = getLength(headB);
        ListNode tmpListNode;
        int tmp;
        if (length2 > length1) {
            tmpListNode = headA;
            headA = headB;
            headB = tmpListNode;
            tmp = length2;
            length2 = length1;
            length1 = tmp;
        }
        while (length1 != length2) {
            headA = headA.next;
            length1--;
        }
        while (headA != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}
