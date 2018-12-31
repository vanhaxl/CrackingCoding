package leetcode.one_fifty;

import java.util.ArrayList;
import java.util.List;

public class A_22_GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("()");
        }
        result.add(sb.toString());
        return result;
    }
}
