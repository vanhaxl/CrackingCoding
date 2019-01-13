package leetcode.one00_one50;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A_139_WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] arr = new boolean[s.length() + 1];
        arr[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] && set.contains(s.substring(j, i))) {
                    arr[i] = true;
                    break;
                }
            }
        }
        return arr[s.length()];
    }

}
