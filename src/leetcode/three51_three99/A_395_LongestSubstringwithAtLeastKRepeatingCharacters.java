package leetcode.three51_three99;

public class A_395_LongestSubstringwithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        String s = "ababacb";
        System.out.println(longestSubstring(s, 3));
    }

    public static int longestSubstring(String s, int k) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int max = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] < k) {
                max = Math.max(max, count);
                count = 0;
            } else {
                count++;
            }
        }

        return Math.max(max, count);

    }
}

/*
ababacb
abbbbccccdddddeffff
 */