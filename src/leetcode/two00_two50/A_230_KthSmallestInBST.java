package leetcode.two00_two50;

import leetcode.common.TreeNode;

public class A_230_KthSmallestInBST {
    static Integer ans = null;
    public static  void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println(kthSmallest(root, 1));
    }
    public static int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        kthSmallest(root.left, k);
        //visit
        if(--k == 0) return root.val;
        kthSmallest(root.right, k);
        return 0;
    }
}

/*
Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
 */
