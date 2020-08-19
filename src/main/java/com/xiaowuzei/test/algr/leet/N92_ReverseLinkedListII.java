package com.xiaowuzei.test.algr.leet;

public class N92_ReverseLinkedListII {
    public static void main(String[] args) {
        System.out.println(new N92_ReverseLinkedListII().reverseBetween(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, null))))), 2, 4));

//        System.out.println(new N92_ReverseLinkedListII().reverseBetween(new ListNode(1, null), 1, 1));
    }

    public ListNode reverseBetween2(final ListNode head, int m, int n) {
        ListNode head1 = null;
        ListNode tail1 = null;
        ListNode head2 = null;
        ListNode tail2 = null;
        ListNode head3 = null;
        int index = 1;
        if (m == 1) {
            head1 = null;
            tail1 = null;
        } else {
            head1 = head;
            tail1 = head;
            while (tail1 != null && index < m - 1) {
                tail1 = tail1.next;
                index++;
            }
        }

        if (tail1 == null) {
            tail2 = head;
            head2 = head;
        } else {
            tail2 = tail1.next;
            head2 = tail1.next;
            index++;
        }
        ListNode tmp;
        ListNode p = head2;
        while (p != null && index <= n) {
            tmp = p.next;
            p.next = head2;
            head2 = p;
            p = tmp;
            index++;
        }
        head3 = p;

        if (head1 == null) {
            head1 = head2;
        } else {
            tail1.next = head2;
        }
        if (tail2 != null) {
            tail2.next = head3;
        }
        return head1;
    }

    public ListNode reverseBetween(final ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        } else {
            head.next = reverseBetween(head.next, m - 1, n - 1);
            return head;
        }
    }


    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }
}
