package leetcode.three00_three50;

import leetcode.common.ListNode;

public class A_328_OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(oddEvenList(head));
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode tmp = dummy1;
        ListNode tmp2 = dummy2;
        ListNode cur = head;
        boolean even = true;
        while (cur != null) {
            if (even) {
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
                tmp.next = null;
            } else {
                tmp2.next = cur;
                cur = cur.next;
                tmp2 = tmp2.next;
                tmp2.next = null;
            }
            even = !even;
        }
        tmp.next = dummy2.next;
        return dummy1.next;

    }
}

/*
Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL


Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
 */
