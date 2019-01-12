package leetcode.one00_one50;

import leetcode.common.ListNode;

public class A_148_SortList {
    public static  void main(String[] args){
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode result = sortList(head);
        System.out.println(result);
    }

    public static ListNode sortList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        //merge
        ListNode result = sort(l1, l2);
        return result;

    }

    public static ListNode sort(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tmp.next = l1;
                l1 = l1.next;
            } else{
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if(l1 != null) tmp.next = l1;
        if(l2 != null) tmp.next = l2;
        return dummy.next;
    }
}
