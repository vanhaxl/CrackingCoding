package leetcode.two00_two50;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    String word;
    TrieNode[] next = new TrieNode[26];
}

public class A_212_WordSearch_Trie {
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
        TrieNode root = buildTrie(words); //O(l1l2)
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) { //O(mn)
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    public static void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {
        char c = board[i][j];
        if (c == '.' || root.next[c - 'a'] == null) return;
        TrieNode p = root.next[c - 'a'];
        if (p.word != null) {
            result.add(p.word);
            p.word = null;
        }
        board[i][j] = '.';
        if (i > 0) dfs(board, i - 1, j, p, result);
        if (j > 0) dfs(board, i, j - 1, p, result);
        if (i < board.length - 1) dfs(board, i + 1, j, p, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, result);
        board[i][j] = c;

    }

    public static TrieNode buildTrie(String[] words) { //O(l1l2)
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new TrieNode();
                }
                cur = cur.next[c - 'a'];
            }
            cur.word = word;
        }
        return root;
    }


}

/*
use dfs with Trie is better because
- only dfs: O(mnl1l2)
- dfs + trie: O(mn) + O(l1l2)

mxn: size of board
l1: len of words
l2: len of each word in word


but Trie use more space: O(l1l2) to build Trie
 */
