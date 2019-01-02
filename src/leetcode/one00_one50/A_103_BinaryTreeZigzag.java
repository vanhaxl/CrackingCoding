package leetcode.one00_one50;

import leetcode.common.TreeNode;

import java.util.*;

public class A_103_BinaryTreeZigzag {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return result;
        queue.add(root);
        TreeNode cur;
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                cur = queue.remove();
                list.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            if(reverse){
                Collections.reverse(list);
            }
            result.add(list);
            reverse = !reverse;
        }
        return result;
    }
}
