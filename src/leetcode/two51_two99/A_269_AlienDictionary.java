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
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>(); // can use int[26] to optimize;

        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) return "";
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                degree.put(c, 0);
            }
        } // firstly, all degree will be zero

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
                        degree.put(c2, degree.get(c2) + 1); // increase degree for only char c1 (!set.contains(c2))
                    }
                    break; // need break, because we only get the 1 st different character. other no need.
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                queue.add(c);
            }
        } // degree = 0 means the char doesn't have any follower. they will be first in alien alphabet
        while (!queue.isEmpty()) {
            char c = queue.remove();
            result.append(c);
            if (map.containsKey(c)) {
                Set<Character> set = map.get(c);
                for (char c2 : set) {
                    degree.put(c2, degree.get(c2) - 1); //reduce degree for the follower until it zero
                    if (degree.get(c2) == 0) queue.add(c2); // it will be added in queue.
                }
            }
        }
        if (result.length() != degree.size()) return "";
        return result.toString();
    }
}
