package leetcode.one_fifty;

import leetcode.common.ListNode;

public class A_19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(a, 2));

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        slow.next = head;

        for(int i = 1; i<= n; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;

    }

}

/*
the idea is make the fast run faster than n node compare with slow.
- start from dummy because if we want to remove the head.
- when fast.next = null means fast is last node, slow will be node which is previous the deleted node.
- want to delete, just set slow.next = slow.next.next;
Given linked list: 1->2->3->4->5, and n = 2.
n= 5

After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
