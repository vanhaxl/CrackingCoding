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
