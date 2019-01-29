package leetcode.one_fifty;

import leetcode.common.ListNode;

public class A_25_ReverseNodeInkGroup {
    public static  void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseKGroup(head, 2);
        System.out.println(result);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        int len = 0;
        ListNode l = head; //len is the length of this list
        while(l != null)
        {
            len++;
            l = l.next;
        }

        int round = len / k;   //cut the list, so we have 'round' lists with size k
        if(round == 0) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 0; i < round; i++)
        {
            //for each list with size k, reverse it
            ListNode start = pre.next;
            ListNode then = start.next;
            for(int j = 0; j < k-1; j++)
            {
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
                then = start.next;
            }
            pre = start;
        }
        return dummy.next;
    }
}
