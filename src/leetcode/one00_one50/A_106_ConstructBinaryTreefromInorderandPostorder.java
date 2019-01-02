package leetcode.one00_one50;

import leetcode.common.TreeNode;

public class A_106_ConstructBinaryTreefromInorderandPostorder {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode a = buildTree(inorder, postorder);
        System.out.println(a.val);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, 0, inorder.length);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder, int idx1, int idx2, int len){
        if(len == 0) return null;
        TreeNode node = new TreeNode(postorder[idx2+len-1]);
        int leftLen = 0;
        while(inorder[idx1 + leftLen] != postorder[idx2 + len -1]){
            leftLen ++;
        }
        node.left = buildTree(inorder, postorder, idx1, idx2, leftLen);
        node.right = buildTree(inorder, postorder, idx1+leftLen +1, idx2+leftLen, len - leftLen -1);
        return node;
    }
}
