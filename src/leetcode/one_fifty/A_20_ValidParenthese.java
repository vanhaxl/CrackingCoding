package leetcode.one_fifty;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class A_20_ValidParenthese {
    private static Map<Character, Character> map;
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    static {
        map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        map.put('<', '>');
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if(map.containsKey(c)){
                stack.push(map.get(c));
            } else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
