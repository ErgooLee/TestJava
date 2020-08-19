package com.xiaowuzei.test.algr.leet;

public class N234_PalindromeLinkedList {

    public static void main(String[] args) {
        System.out.println(new N234_PalindromeLinkedList().isPalindrome(new ListNode(1,
                new ListNode(2, new ListNode(2, new ListNode(1, null))))));
        System.out.println(new N234_PalindromeLinkedList().isPalindrome(new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1, null)))))));

        System.out.println(new N234_PalindromeLinkedList().isPalindrome(new ListNode(1, null)));
        System.out.println(new N234_PalindromeLinkedList().isPalindrome(new ListNode(1, new ListNode(1, null))));
        System.out.println(new N234_PalindromeLinkedList().isPalindrome(new ListNode(1, new ListNode(2, null))));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        System.out.println(slow);
        slow = reverse(slow);
        while (slow != null && head != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
