package leetcode.a_1000_a_1050;

import leetcode.common.TreeNode;

public class A_1008_ConstructBSTFromPreOrder {
    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 7, 10, 12};
        TreeNode result = bstFromPreorder(arr);
        System.out.println(result.toString());
    }

    public static TreeNode bstFromPreorder(int[] arr) {
        if (arr.length == 0) return null;
        TreeNode root = helper(arr, 0, arr.length - 1);
        return root;
    }

    public static TreeNode helper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(arr[start]);
        int i = start + 1;
        while (i <= end && arr[i] < root.val) {
            i++;
        }
        root.left = helper(arr, start + 1, i - 1);
        root.right = helper(arr, i, end);
        return root;
    }
}
