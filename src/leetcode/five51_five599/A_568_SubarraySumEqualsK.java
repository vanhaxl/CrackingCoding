package leetcode.five51_five599;

import java.util.HashMap;
import java.util.Map;

public class A_568_SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {-1, -1, 1};
        System.out.println(subarraySum(nums, 0));
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}

/*
Solution 1. Brute force. We just need two loops (i, j) and
test if SUM[i, j] = k.
Time complexity O(n^2), Space complexity O(1).

//cummulative sum
public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int start = 0; start< nums.length; start++){
            int sum = 0;
            for(int end = start; end < nums.length; end++){
                sum += nums[end];
                if(sum == k){
                    count ++;
                }
            }
        }
        return count;
    }

Solution 2. From solution 1, we know the key to solve this problem is SUM[i, j].
So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j].
To achieve this, we just need to go through the array, calculate the current
sum and save number of all seen PreSum to a HashMap.
Time complexity O(n), Space complexity O(n).


 */
