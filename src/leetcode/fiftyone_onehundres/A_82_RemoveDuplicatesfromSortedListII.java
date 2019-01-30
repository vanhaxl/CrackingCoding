package leetcode.fiftyone_onehundres;

import leetcode.common.ListNode;

public class A_82_RemoveDuplicatesfromSortedListII {
    public static  void main(String[] args){

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return dummy.next;
    }
}

/*
Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
 */

/*
cur giong nnhau , remove het, pre luon theo sau, start tu dummy
 */
