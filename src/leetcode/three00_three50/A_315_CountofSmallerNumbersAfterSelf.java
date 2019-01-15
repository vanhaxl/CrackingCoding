package leetcode.three00_three50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class TreeNode {
    int val;
    int duplicate;
    int leftSize;
    TreeNode left, right;

    public TreeNode(int val, int dup, int leftSize) {
        this.val = val;
        this.duplicate = dup;
        this.leftSize = leftSize;
    }

}

public class A_315_CountofSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1};
        System.out.println(countSmaller(arr));
    }

    static int ans;

    public static List<Integer> countSmaller(int[] nums) {
        TreeNode root = null;
        List<Integer> list = new LinkedList<>();
        for(int i = nums.length -1; i>= 0; i--){
            ans = 0;
            root = insert(root, nums[i]);
            list.add(0, ans);
        }
        return list;
    }

    public static TreeNode insert(TreeNode root, int val){
        if(root == null) return new TreeNode(val, 1, 0);
        if(val > root.val){
            root.right = insert(root.right, val);
            ans += root.duplicate + root.leftSize; //turn right, add dup and left size to ans
        } else if(val < root.val){
            root.left = insert(root.left, val);
            root.leftSize ++;
        } else{
            root.duplicate ++;
            ans += root.leftSize;
        }
        return root;
    }

    /*Solution BST:
    - track the number of element smaller than the current node
- count total number of element smaller than the current node while inserting value into the tree
- time complexity: O(nlogn)
- Space complexity: O(k) K: # of unique element
     */


// Solution : Merge Sort
//    public static List<Integer> countSmaller(int[] nums) {
//        List<Integer> result = new ArrayList<>();
//
//        count = new int[nums.length];
//        int[] indexes = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            indexes[i] = i;
//        }
//        mergeSort(nums, indexes, 0, nums.length - 1);
//
//        for (int i = 0; i < count.length; i++) {
//            result.add(count[i]);
//        }
//        return result;
//    }
//
//    private static void mergeSort(int[] nums, int[] indexes, int start, int end) {
//        if (end <= start) return;
//        int mid = (start + end) / 2;
//        mergeSort(nums, indexes, start, mid);
//        mergeSort(nums, indexes, mid + 1, end);
//        merge(nums, indexes, start, end);
//    }
//
//    private static void merge(int[] nums, int[] indexes, int start, int end) {
//        int mid = (start + end) / 2;
//        int leftIndex = start;
//        int rightIndex = mid + 1;
//        int rightCount = 0;
//        int[] newIndexes = new int[end - start + 1];
//        int sortIndex = 0;
//        while (leftIndex <= mid && rightIndex <= end) {
//            if (nums[indexes[rightIndex]] < nums[indexes[leftIndex]]) {
//                newIndexes[sortIndex] = indexes[rightIndex];
//                rightCount++;
//                rightIndex++;
//            } else {
//                newIndexes[sortIndex] = indexes[leftIndex];
//                count[indexes[leftIndex]] += rightCount;
//                leftIndex++;
//            }
//            sortIndex++;
//        }
//        while (leftIndex <= mid) {
//            newIndexes[sortIndex] = indexes[leftIndex];
//            count[indexes[leftIndex]] += rightCount;
//            sortIndex++;
//            leftIndex++;
//        }
//
//        while (rightIndex <= end) {
//            newIndexes[sortIndex] = indexes[rightIndex];
//            sortIndex++;
//            rightIndex++;
//        }
//        for (int i = start; i <= end; i++) {
//            indexes[i] = newIndexes[i - start];
//        }
//    }


}

/*

Solution 1: merge sort
Solution 2: Binary Search Tree

 */
