package nine00_nine50;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import leetcode.common.TreeNode;

public class A_993_CousinsinBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		System.out.println(isCousins(root, 3, 6));
	}

	public static boolean isCousins(TreeNode root, int x, int y) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.remove();
				if (node.val == x || node.val == y) {
					for (int j = i + 1; j < size; j++) {
						TreeNode node2 = queue.remove();
						if (node2.val == x || node2.val == y) {
							return true;
						}
					}
					return false;
				}
				if (node.left != null && node.right != null) {
					if ((node.left.val == x || node.left.val == y) && (node.right.val == x || node.right.val == y)) {
						return false;
					}
					queue.add(node.left);
					queue.add(node.right);
				} else if (node.left != null) {
					queue.add(node.left);
				} else if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return false;
	}

}
