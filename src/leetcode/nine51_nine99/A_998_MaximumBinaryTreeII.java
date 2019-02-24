package leetcode.nine51_nine99;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class A_998_MaximumBinaryTreeII {
    public static void main(String[] args) {

    }

    public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> list = inorderTraversal(root);
        list.add(val);
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        TreeNode result = constructMaximumBinaryTree(nums);
        return result;

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        //inorder: left root right
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public static void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    public static TreeNode construct(int[] nums, int l, int r) {
        if (l == r)
            return null;
        int max_i = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = construct(nums, l, max_i);
        root.right = construct(nums, max_i + 1, r);
        return root;
    }

    public static int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }


}
