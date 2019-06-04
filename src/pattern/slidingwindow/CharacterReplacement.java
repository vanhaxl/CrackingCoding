package pattern.slidingwindow;

public class CharacterReplacement {
    public static void main(String[] args) {

        String s = "aababba";
        System.out.println(findLength(s, 2));
    }

    public static int findLength(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'a']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start++) - 'a']--;
            }
        }
        return s.length() - start-1;
    }
}

/*
Input:
s = "abab", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.

Input:
s = "aababba", k = 1

Output:
4
 */

/*
 int len = s.length();
int[] count = new int[26];
int start = 0, maxCount = 0, maxLength = 0;
for (int end = 0; end < len; end++) {
    maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
    while (end - start + 1 - maxCount > k) {
        count[s.charAt(start) - 'A']--;
        start++;
    }
    maxLength = Math.max(maxLength, end - start + 1);
}
return maxLength;
 */


