package leetcode.one_fifty;

public class A_8_StringToInteger {

    private static final int maxDiv10 = Integer.MAX_VALUE / 10;

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
    }

    public static int myAtoi(String s) {
        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i)))
            i++;
        int sign = 1;
        if (i < n && s.charAt(i) == '+') {
            i++;
        } else if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = Character.getNumericValue(s.charAt(i));
            if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }

}

/*
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
 */
