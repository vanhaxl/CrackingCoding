package leetcode.one_fifty;

import leetcode.common.ListNode;

public class A_23_MergeKSortedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = {l1, l2, l3};
        System.out.println(mergeKLists(list));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int end = lists.length -1;
        while(end > 0){
            int start = 0;
            while(start < end){
                lists[start] = merge2Lists(lists[start], lists[end]);
                start ++; end --;
            }
        }
        return lists[0];
    }

    public static ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while(l1!= null && l2 != null){
            if(l1.val <= l2.val){
                ListNode node = new ListNode(l1.val);
                tmp.next = node;
                l1 = l1.next;
            } else{
                ListNode node = new ListNode(l2.val);
                tmp.next = node;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if(l1 != null) tmp.next = l1;
        if(l2 != null) tmp.next = l2;
        return dummy.next;
    }
}

/*
Solution 1: create a list, get all values val. Collection sort, create a ListNode by sorted val list
Time: nklog(nk)
Space: O(nk)

Solution2: brute force. merge 2 list at a time
Time: n + 2n + ... + (k-1)n  -> O(nk^2)
Space: O(1)

Solution 3: Use Heap. Priority Queue in Java. store each smallest elements from each list
Time: insert to heap -> log(k) . We have nk element -> nklog(k) time
Space: O(k). the tree store each k element at a time


Solution 4: (optimize). Use merge sort (divide and conquer) -> klogk  time -> total: nklog(k)
# list: k -> k/2 -> k/4 -> ... -> 1
# elements of each list: n + 2n + .. + 2^logk n
==> time: kn + k/2*2n + ... 2^logk *n = kn + kn +... + kn = nklog(k)
Space: O(1)
 */
