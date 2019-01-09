package leetcode.one_fifty;

import leetcode.common.ListNode;

public class A_2_AddTwoNumbers {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        int value = 0, remember = 0;
        while (l1 != null && l2 != null) {
            int sum = (l1.val + l2.val);
            value = sum % 10;
            remember = sum / 10;
            ListNode tmpNode = new ListNode(value);

        }
        return dummy.next;
    }
}

/*
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
