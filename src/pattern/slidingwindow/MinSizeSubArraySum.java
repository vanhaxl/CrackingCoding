package pattern.slidingwindow;

public class MinSizeSubArraySum {
    public static void main(String[] args) {

        int result = MinSizeSubArraySum.findMinSubArray(new int[]{2, 1, 5, 2, 3, 2}, 7);
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(new int[]{2, 1, 5, 2, 8}, 7);
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(new int[]{3, 4, 1, 1, 6}, 8);
        System.out.println("Smallest subarray length: " + result);

    }

    public static int findMinSubArray(int[] nums, int s) {
        int result = Integer.MAX_VALUE;

        int windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd]; // add the next element
            //shrink the window as small as possible until the windowSum is smaller than S
            while (windowSum >= s) {
                result = Math.min(result, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];//subtract the element going out
                windowStart++; //slide the window ahead
            }
        }
        return result;
    }
}
