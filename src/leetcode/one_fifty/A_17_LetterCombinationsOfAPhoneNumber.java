package leetcode.one_fifty;

import java.util.ArrayList;
import java.util.List;

public class A_17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String input = "23";
        System.out.println(letterCombinations(input));
    }

    public static List<String> letterCombinations(String digits) {
        String[] arr = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int tmp = Character.getNumericValue(digits.charAt(i));
            String newString = arr[tmp];
            List<String> tmpList = new ArrayList<>();
            for (String s : result) {
                for (int j = 0; j < newString.length(); j++) {
                    tmpList.add(s + newString.charAt(j));
                }
            }
            result = tmpList;
        }
        return result;
    }
}
