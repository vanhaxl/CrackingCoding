package leetcode.fiftyone_onehundres;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class A_95_UniqueBinarySearchTreeII {
    public static void main(String[] args) {
        List<TreeNode> list = generateTrees(3);
        for(TreeNode node: list){
            System.out.println(node.val);
        }


    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateBST(1, n);
    }

    public static List<TreeNode> generateBST(int lo, int hi) {
        List<TreeNode> result = new ArrayList<>();
        if (lo > hi) {
            result.add(null);
            return result;
        }
        for (int i = lo; i <= hi; i++) {
            for (TreeNode left : generateBST(lo, i - 1)) {
                for (TreeNode right : generateBST(i + 1, hi)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }

}


/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
