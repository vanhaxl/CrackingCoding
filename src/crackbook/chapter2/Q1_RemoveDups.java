package crackbook.chapter2;

import leetcode.common.ListNode;

public class Q1_RemoveDups {
    public static  void main(String[] args){
        ListNode a = new ListNode(1);
        a.next = new ListNode(10);
        a.next.next = new ListNode(5);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        System.out.println(a.toString());
        ListNode result = removeDups(a);
        System.out.println(result.toString());
    }

    public static ListNode removeDups(ListNode head){
        return null;
    }

}

