package leetcode.nine00_nine50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_996_NumberofSquarefulArrays {
	public static int count;

	public static void main(String[] args) {
		//int[] nums = { 1, 17, 8 };
		int[] nums = { 99, 62, 10, 47, 53, 9, 83, 33, 15, 24 };
		System.out.println(numSquarefulPerms(nums));
	}

	public static int numSquarefulPerms(int[] nums) {
		count = 0;
		List<Integer> tempList = new ArrayList<>();
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		backtrack(tempList, used, nums);
		return count;
	}

	public static void backtrack(List<Integer> tempList, boolean[] used, int[] nums) {
		if (tempList.size() == nums.length) {
			System.out.println(tempList);
			count++;
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
					|| (!tempList.isEmpty() && !isPerfectSquare(nums[i] + tempList.get(tempList.size() - 1))))
				continue;
			tempList.add(nums[i]);
			used[i] = true;
			backtrack(tempList, used, nums);
			used[i] = false;
			tempList.remove(tempList.size() - 1);

		}
	}

	static boolean isPerfectSquare(int x) {
		double sr = Math.sqrt(x);
		return ((sr - Math.floor(sr)) == 0);
	}

}
