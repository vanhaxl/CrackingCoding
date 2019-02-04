package leetcode.one00_one50;

import java.util.*;

public class A_126_WordLadderII {
    public static  void main(String[] args){

    }

    public static List<List<String>> findLadders(String start, String end, List<String> wordList){
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

    public static void bfs(String start, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance){

    }

    public static void dfs(String cur, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance, List<String> solution, List<List<String>> res){

    }
}

/*
The basic idea is:

1). Use BFS to find the shortest distance between start and end,
tracing the distance of crossing nodes from start node to end node,
and store node's next level neighbors to HashMap;

2). Use DFS to output paths with the same distance as the shortest distance from distance HashMap:
compare if the distance of the next level node equals the distance of the current node + 1.
 */
