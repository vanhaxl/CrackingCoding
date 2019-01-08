package leetcode.three00_three50;

import java.util.ArrayList;
import java.util.List;


public class A_315_CountofSmallerNumbersAfterSelf {
    static int[] count;

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1};
        System.out.println(countSmaller(arr));
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();

        count = new int[nums.length];
        int[] indexes = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, indexes, 0, nums.length - 1);

        for (int i = 0; i < count.length; i++) {
            result.add(count[i]);
        }
        return result;
    }

    private static void mergeSort(int[] nums, int[] indexes, int start, int end) {
        if (end <= start) return;
        int mid = (start + end) / 2;
        mergeSort(nums, indexes, start, mid);
        mergeSort(nums, indexes, mid + 1, end);
        merge(nums, indexes, start, end);
    }

    private static void merge(int[] nums, int[] indexes, int start, int end) {
        int mid = (start + end) / 2;
        int leftIndex = start;
        int rightIndex = mid + 1;
        int rightCount = 0;
        int[] newIndexes = new int[end - start + 1];
        int sortIndex = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[indexes[rightIndex]] < nums[indexes[leftIndex]]) {
                newIndexes[sortIndex] = indexes[rightIndex];
                rightCount++;
                rightIndex++;
            } else {
                newIndexes[sortIndex] = indexes[leftIndex];
                count[indexes[leftIndex]] += rightCount;
                leftIndex++;
            }
            sortIndex++;
        }
        while (leftIndex <= mid) {
            newIndexes[sortIndex] = indexes[leftIndex];
            count[indexes[leftIndex]] += rightCount;
            sortIndex++;
            leftIndex++;
        }

        while (rightIndex <= end) {
            newIndexes[sortIndex] = indexes[rightIndex];
            sortIndex++;
            rightIndex++;
        }
        for (int i = start; i <= end; i++) {
            indexes[i] = newIndexes[i - start];
        }
    }


}
