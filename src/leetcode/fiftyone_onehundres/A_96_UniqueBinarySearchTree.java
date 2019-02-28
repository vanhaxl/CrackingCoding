package leetcode.fiftyone_onehundres;

public class A_96_UniqueBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = g[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                g[i] += g[j - 1] * g[i - j];
        }
        return g[n];
    }


}
/*
O(n^2)
O(1)
 */










/*
g(0) = 1
g(1) = 1
g(n) = f(1, n) + f(2, n) + .. + f(n, n)

f(i, n): #bst in which i is root

f(i, n) = g(i-1) * g(n-i)

vi du
f(3, 7) = g(2) * g(4)
 */

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
