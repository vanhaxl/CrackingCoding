package leetcode.three51_three99;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A_395_LongestSubstringwithAtLeastKRepeatingCharacters {
    static int result;

    public static void main(String[] args) {
        String s = "baaabcb";
        System.out.println(longestSubstring(s, 3));
    }

    public static int longestSubstring(String s, int k) {
        result = 0;

        List<String> list = new ArrayList<>();
        list.add(s);
        helper(list, k);
        return result;
    }

    public static void helper(List<String> list, int k) {
        for (String s : list) {
            if (s == null || s.isEmpty()) continue;
            Set<Character> charsUnqualified = getUnqualified(s, k); // O(n)
            if (charsUnqualified.isEmpty()) {
                result = Math.max(result, s.length());
            } else {
                int start = 0;
                List<String> newList = new ArrayList<>();
                for (int i = 0; i < s.length(); i++) {
                    if (charsUnqualified.contains(s.charAt(i))) {
                        newList.add(s.substring(start, i));
                        start = i + 1;
                    }
                }
                if (start != s.length() && start != 0) {
                    newList.add(s.substring(start));
                }
                helper(newList, k);
            }
        }
    }

    public static Set<Character> getUnqualified(String s, int k) { //O(n)
        Set<Character> set = new HashSet<>();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0 && arr[i] < k) {
                set.add((char) (i + 'a'));
            }
        }
        return set;
    }
}

/*
ababacb
abbbbccccdddddeffff
 */