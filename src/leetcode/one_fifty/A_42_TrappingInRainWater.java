package leetcode.one_fifty;

public class A_42_TrappingInRainWater {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0;
        int maxHeight = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                maxHeight = Math.max(maxHeight, height[left]);
                result += maxHeight - height[left];
                left++;
            } else {
                maxHeight = Math.max(maxHeight, height[right]);
                result += maxHeight - height[right];
                right--;
            }
        }
        return result;

    }
}

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

For each element in the array, we find the maximum level of water
it can trap after the rain, which is equal to the minimum of 2 maximum height
of bars on both the sides minus its own height.

Solution 2: use stack
- use stack to push index of elements
- If height[current] > height[top], calculate
 */

