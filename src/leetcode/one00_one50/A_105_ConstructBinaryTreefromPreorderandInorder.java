package leetcode.one00_one50;

import leetcode.common.TreeNode;

public class A_105_ConstructBinaryTreefromPreorderandInorder {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode a = buildTree(preorder, inorder);
        System.out.println(a.val);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, preorder.length);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int index1, int index2, int len) {
        if (len == 0) return null;

        int leftLen = 0;
        while (preorder[index1] != inorder[index2 + leftLen]) {
            leftLen++;
        }

        TreeNode root = new TreeNode(preorder[index1]);
        root.left = buildTree(preorder, inorder, index1 + 1, index2, leftLen);
        root.right = buildTree(preorder, inorder, index1 + leftLen + 1, index2 + leftLen + 1, len - leftLen - 1);
        return root;
    }


}
