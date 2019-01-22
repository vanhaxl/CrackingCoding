package leetcode.two51_two99;

import java.util.*;

public class A_269_AlienDictionary {
    public static void main(String[] args) {
        String[] arr = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };

        System.out.println(alienOrder(arr));
    }

    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();// character and set of character follow key character
        int[] degree = new int[26];
        Arrays.fill(degree, -1);

        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) return "";

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                degree[c - 'a'] = 0;
            }
        }

        int count = 0;
        for (int x : degree) {
            if (x == 0) count++;
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            for (int j = 0; j < len; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1)) set = map.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree[c2 - 'a']++;// increase degree for only char c1 (!set.contains(c2))
                    }
                    break; // need break, because we only get the 1 st different character. other no need.
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 0) {
                char c = (char) (i + 'a');
                queue.add(c);
            }
        } // degree = 0 means the char doesn't have any follower. they will be first in alien alphabet
        while (!queue.isEmpty()) {
            char c = queue.remove();
            result.append(c);
            if (map.containsKey(c)) {
                Set<Character> set = map.get(c);
                for (char c2 : set) {
                    degree[c2 - 'a']--; //reduce degree for the follower until it zero
                    if (degree[c2 - 'a'] == 0) queue.add(c2); // it will be added in queue.
                }
            }
        }
        if (result.length() != count) return "";
        return result.toString();
    }
}
