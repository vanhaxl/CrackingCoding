package leetcode.one00_one50;

import java.util.*;

public class A_127_WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //Add words in wordList to a set
        Set<String> list = new HashSet<>(wordList);

        //This set store the words visited before, add beginWord into visited at first
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        //Keep track the BFS level we are
        int level = 1;

        //Queue
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            //This tell us the total number of words in the current level
            int size = queue.size();
            //traverse this level using for loop
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                char[] temp = curr.toCharArray();
                //Change each character of word
                for (int j = 0; j < temp.length; j++) {
                    char temping = temp[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        temp[j] = c;
                        String now = String.valueOf(temp);
                        //Make sure new word is in wordList and has not been visited
                        if (list.contains(now) && !visited.contains(now)) {
                            //If we found the endWord, return
                            if (now.equals(endWord)) {
                                return level + 1;
                            }
                            queue.add(now);
                            visited.add(now);
                        }
                        //Remember to restore the word
                        temp[j] = temping;
                    }
                }
            }
            //Searching in current level end, move to next level
            level++;
        }

        //No possible transformation, return 0
        return 0;
    }
}
