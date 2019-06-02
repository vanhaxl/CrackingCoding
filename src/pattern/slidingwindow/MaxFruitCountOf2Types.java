package pattern.slidingwindow;

public class MaxFruitCountOf2Types {
    public static void main(String[] args) {

        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));

    }

    public static int findLength(char[] arr) {
        int result = 0;
        int[] char_set = new int[26];
        int count = 0;

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char_set[arr[windowEnd] - 'A']++;
            if (char_set[arr[windowEnd] - 'A'] == 1) {
                count++;

            }
            while (count > 2) {
                char_set[arr[windowStart] - 'A']--;
                if (char_set[arr[windowStart] - 'A'] == 0) {
                    count--;
                }
                windowStart++;


            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
    }
}
/*
time complexity: O(n)
space complexity:
 */
