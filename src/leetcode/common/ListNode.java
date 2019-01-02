package leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public int getSize(){
        int s = 1;
        ListNode tmp = this.next;
        while(tmp != null){
            s++;
            tmp = tmp.next;
        }
        return s;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.val);
        ListNode tmp = this.next;
        while(tmp!= null){
            sb.append("->");
            sb.append(tmp.val);
            tmp = tmp.next;
        }
        return sb.toString();
    }
}
