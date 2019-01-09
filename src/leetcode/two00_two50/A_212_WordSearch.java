package leetcode.two00_two50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A_212_WordSearch {
    public static void main(String[] args) {
        String[] words = {"oath", "pea", "eat", "rain"};
        //String[] words = {"eat"};

        char[][] board = {
                {
                        'o', 'a', 'a', 'n'
                },
                {
                        'e', 't', 'a', 'e'
                },
                {
                        'i', 'h', 'k', 'r'
                },
                {
                        'i', 'f', 'l', 'v'
                }
        };

        System.out.println(findWords(board, words));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (!set.contains(word)) {
                set.add(word);
                if (check(board, word)) {
                    list.add(word);
                }
            }
        }
        return list;
    }

    public static boolean check(char[][] board, String s) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (s.charAt(0) == board[i][j]) {
                    if (dfs(board, s, i, j, 0)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String s, int i, int j, int index) {
        if (index == s.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        } else if (board[i][j] != s.charAt(index)) {
            return false;
        } else {
            char tmp = board[i][j];
            board[i][j] = '.';
            boolean result = dfs(board, s, i + 1, j, index + 1) ||
                    dfs(board, s, i - 1, j, index + 1) ||
                    dfs(board, s, i, j + 1, index + 1) ||
                    dfs(board, s, i, j - 1, index + 1);
            board[i][j] = tmp;
            return result;
        }

    }
}
