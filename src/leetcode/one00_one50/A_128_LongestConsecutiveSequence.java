package leetcode.one00_one50;

import java.util.HashSet;
import java.util.Set;

public class A_128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int max = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int count = 0;
                int current = x;
                while (set.contains(current + 1)) {
                    count++;
                    current++;
                }
                max = Math.max(max, count + 1);
            }
        }
        return max;
    }
}
