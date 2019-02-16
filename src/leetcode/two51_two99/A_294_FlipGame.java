package leetcode.two51_two99;

import java.util.HashMap;
import java.util.Map;

public class A_294_FlipGame {
    public static void main(String[] args) {
        String s = "++++";
        System.out.println(canWin(s));
    }

    public static boolean canWin(String s) {
        if (s == null || s.isEmpty()) return false;
        Map<String, Boolean> memo = new HashMap<>();
        StringBuilder sb = new StringBuilder(s);
        backtrack(sb, memo);
        return memo.get(s);
    }

    public static boolean backtrack(StringBuilder sb, Map<String, Boolean> memo) {
        if (memo.containsKey(sb.toString())) {
            return memo.get(sb.toString());
        }

        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '+' && sb.charAt(i + 1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                if (!backtrack(sb, memo)) {
                    sb.setCharAt(i, '+');
                    sb.setCharAt(i + 1, '+');
                    memo.put(sb.toString(), true);
                    return true;
                }
                sb.setCharAt(i, '+');
                sb.setCharAt(i + 1, '+');
            }
        }
        memo.put(sb.toString(), false);
        return false;
    }
}

/*
You are playing the following Flip Game with your friend: Given a string that contains only these two characters:
+ and -, you and your friend take turns to flip two consecutive "++" into "--".
The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

Example:

Input: s = "++++"
Output: true
Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 */

/*
The idea is try to replace every "++" in the current string s to "--" and see if the opponent can win or not,
if the opponent cannot win, great, we win!

For the time complexity, here is what I thought, let's say the length of the input string s is n,
there are at most n - 1 ways to replace "++" to "--" (imagine s is all "+++..."),
once we replace one "++", there are at most (n - 2) - 1 ways to do the replacement,
it's a little bit like solving the N-Queens problem,
the time complexity is (n - 1) x (n - 3) x (n - 5) x ..., so it's O(n!!), double factorial.

That's what I thought, but I could be wrong :)

public boolean canWin(String s) {
  if (s == null || s.length() < 2) {
    return false;
  }

  for (int i = 0; i < s.length() - 1; i++) {
    if (s.startsWith("++", i)) {
      String t = s.substring(0, i) + "--" + s.substring(i + 2);

      if (!canWin(t)) {
        return true;
      }
    }
  }

  return false;
}
 */

/*
 public boolean canWin(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        Map<String, Boolean> memo = new HashMap<>();
        StringBuilder sb = new StringBuilder(s);
        return dfs(sb, memo);
    }

    private boolean dfs(StringBuilder sb, Map<String, Boolean> memo) {
        if (memo.containsKey(sb.toString())) {
            return memo.get(sb.toString());
        }

        for (int i = 0; i < sb.length()-1; i++) {
            if (sb.charAt(i) == '+' && sb.charAt(i+1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i+1, '-');
                if (!dfs(sb, memo)) {
                    sb.setCharAt(i, '+');
                    sb.setCharAt(i+1, '+');
                    memo.put(sb.toString(), true);
                    return true;
                }
                sb.setCharAt(i, '+');
                sb.setCharAt(i+1, '+');
            }
        }
        memo.put(sb.toString(), false);
        return false;
    }
 */
