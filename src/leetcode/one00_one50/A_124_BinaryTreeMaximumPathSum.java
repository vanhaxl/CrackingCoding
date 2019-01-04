package leetcode.one00_one50;

import leetcode.common.TreeNode;

public class A_124_BinaryTreeMaximumPathSum {

    static int max;
    public static void main(String[] args){
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
            max = Integer.MIN_VALUE;
            maxPathDown(root);
            return max;
    }

    //return the maximum value that could be obtained by traversing a path down from the node
    private static int maxPathDown(TreeNode node){
        if(node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        max = Math.max(max, left+right+node.val);
        return Math.max(left, right) + node.val;
    }
}

/*
The motive behind this approach is that

1. maxPathDown always returns the maximum value that could be obtained by traversing a path down from that node.
The path traversed could either stop at that node or go either right or left from there depending on which is greater.
2. In case the maximum sum that could be obtained down from any of the children is negative, it is reinitialised to
zero in int left = Math.max(0, maxPathDown(node.left)); when it comes back from the left child and similarly
int right = Math.max(0, maxPathDown(node.right)); from the right child.
3. The key thing to understand here is that whenever we finish obtaining the value from the left sub tree and
the right sub tree, we can track the maximum value by adding the left,right
and current node's value without any problem since the left and right values never reduce the value that could be obtained at that stage.
 */
