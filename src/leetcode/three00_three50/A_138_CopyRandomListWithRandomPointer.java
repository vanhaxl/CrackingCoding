package leetcode.three00_three50;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class A_138_CopyRandomListWithRandomPointer {
	public static void main(String[] args) {

	}

	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		Map<RandomListNode, RandomListNode> map = new HashMap<>();

		// copy to hashmap
		RandomListNode cur = head;
		while (cur != null) {
			map.put(cur, cur.next);
			cur = cur.next;
		}

		// make a copy
		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		return map.get(head);
	}
}
