package leetcode.three00_three50;

import java.util.ArrayList;
import java.util.List;

public class A_320_GeneralizedAbbreviation {
    public static void main(String[] args) {
        System.out.println(generateAbbreviations("word"));
    }

    public static List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        backtrack(result, word, 0, "", 0);
        return result;
    }

    private static void backtrack(List<String> result, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) cur += count;
            result.add(cur);
        } else {
            backtrack(result, word, pos + 1, cur, count + 1); // count the character
            backtrack(result, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
        }
    }
}

/*

Write a function to generate the generalized abbreviations of a word.

Note: The order of the output does not matter.

Example:

Input: "word"
Output:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
