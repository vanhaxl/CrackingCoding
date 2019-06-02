package pattern.slidingwindow;

public class MaximumSumSubarrayofSizeK {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 1, 5, 1, 3, 2};

        int[] nums2 = new int[]{2, 3, 4, 1, 5};

        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(nums, 3));

        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(nums2, 2));

    }

    public static int findMaxSumSubArray(int[] nums, int k) {
        int result = Integer.MIN_VALUE;
        int windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd]; // add the next element
            //slide the window, we don't need to slide if we've not hit the required window size of k
            if (windowEnd >= k - 1) {
                result = Math.max(result, windowSum);
                windowSum -= nums[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return result;

    }
}
