package leetcode.fiftyone_onehundres;

import leetcode.common.ListNode;

public class A_86_PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        System.out.println(partition(head, 3));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummyLeft = new ListNode(0);
        ListNode dummyRight = new ListNode(0);
        ListNode tmpLeft = dummyLeft;
        ListNode tmpRight = dummyRight;

        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                tmpLeft.next = cur;
                cur = cur.next;
                tmpLeft = tmpLeft.next;
                tmpLeft.next = null;
            } else {
                tmpRight.next = cur;
                cur = cur.next;
                tmpRight = tmpRight.next;
                tmpRight.next = null;
            }

        }
        tmpLeft.next = dummyRight.next;
        return dummyLeft.next;
    }
}

/*
lam 1 cai left, 1 cai right, di kem la 1 tmpleft, tmpright.
 */
/*
Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

 */
