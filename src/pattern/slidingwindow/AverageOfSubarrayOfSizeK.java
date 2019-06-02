package pattern.slidingwindow;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};

        double[] result = findAverages(nums, 5);
        System.out.println(Arrays.toString(result));

    }

    public static double[] findAverages(int[] nums, int k) {

        double[] result = new double[nums.length - k + 1];

        double windowSum = 0;

        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {

            windowSum += nums[windowEnd]; // add the next element

            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k - 1) {

                result[windowStart] = windowSum / k; // calculate the average

                windowSum -= nums[windowStart]; // subtract the element going out

                windowStart++; // slide the window ahead

            }
        }

        return result;

    }
}

/*
Time complexity: O(N)
Space complexity: O(1)
Brute force: O(NK)
 */
