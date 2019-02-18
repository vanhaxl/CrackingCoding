package leetcode.one_fifty;

import leetcode.common.ListNode;

public class A_2_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(a, b);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        int value = 0, remember = 0, sum = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            sum = a + b +remember;
            value = sum % 10;
            remember = sum / 10;
            tmp.next = new ListNode(value);
            tmp = tmp.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if(remember > 0){
            tmp.next = new ListNode(remember);
        }
        return dummy.next;
    }
}

/*
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
