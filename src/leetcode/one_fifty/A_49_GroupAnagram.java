package leetcode.one_fifty;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A_49_GroupAnagram {

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strings));
    }

    public static List<List<String>> groupAnagrams(String[] strings) {

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String sorted = sort(s);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted, list);
            }
        }
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;

    }

    public static String sort(String s) {
        int[] charSet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charSet[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (charSet[i] != 0) {
                sb.append('a' + i);
                charSet[i]--;
            }
        }
        return sb.toString();
    }


}
/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */
