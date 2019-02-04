package leetcode.one00_one50;

import java.util.*;

public class A_126_WordLadderII {
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(findLadders(start, end, wordList));
    }

    public static List<List<String>> findLadders(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> nodeNeightbors = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        List<String> solution = new ArrayList<>();
        dict.add(start);
        bfs(start, end, dict, nodeNeightbors, distance);
        dfs(start, end, dict, nodeNeightbors, distance, solution, res);
        return res;

    }

    public static void bfs(String start, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
        for (String s : dict) {
            nodeNeighbors.put(s, new ArrayList<>());
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                List<String> neighbors = getNeighbors(cur, dict);
                nodeNeighbors.put(cur, neighbors);
                for (String neighbor : neighbors) {
                    if (!distance.containsKey(neighbor)) {// Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))// Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }
            if (foundEnd)
                break;
        }

    }


    // Find all next level nodes.
    private static List<String> getNeighbors(String node, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char chs[] = node.toCharArray();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    public static void dfs(String cur, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance, List<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }
}

/*

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

The basic idea is:

1). Use BFS to find the shortest distance between start and end,
tracing the distance of crossing nodes from start node to end node,
and store node's next level neighbors to HashMap;

2). Use DFS to output paths with the same distance as the shortest distance from distance HashMap:
compare if the distance of the next level node equals the distance of the current node + 1.
 */
