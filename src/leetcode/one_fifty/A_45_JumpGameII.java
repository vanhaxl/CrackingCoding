package leetcode.one_fifty;

public class A_45_JumpGameII {
    public static void main(String[] args) {
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(jump(nums));
    }

    //mine
    public static int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int maxCanJump = nums[0];
        int result = 1;
        int i = 1;
        int tempMax = maxCanJump;
        while (i < nums.length-1 && i <= maxCanJump) {
            if (nums[i] + i > maxCanJump) {
                tempMax = Math.max(tempMax, nums[i] + i);
                if (maxCanJump >= nums.length - 1) {
                    return result;
                }
            }
            if (i == maxCanJump) {
                maxCanJump = tempMax;
                result++;
            }
            i++;
        }
        return result;
    }
}

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
