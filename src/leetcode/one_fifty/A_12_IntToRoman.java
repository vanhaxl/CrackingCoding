package leetcode.one_fifty;

public class A_12_IntToRoman {

    public static void main(String[] args) {
        int num = 58;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(helper(num / 1000, "", "", "", "M"));
        num %= 1000;
        sb.append(helper(num / 100, "CM", "D", "CD", "C"));
        num %= 100;
        sb.append(helper(num / 10, "XC", "L", "XL", "X"));
        num %= 10;
        sb.append(helper(num, "IX", "V", "IV", "I"));
        return new String(sb);
    }

    public static String helper(int num, String nine, String five, String four, String one) {
        StringBuilder sb = new StringBuilder();
        if (num == 9) {
            sb.append(nine);
        } else {
            if (num >= 5) {
                sb.append(five);
                num -= 5;
            }
            if (num == 4) {
                sb.append(four);
            } else {
                for (int i = 0; i < num; i++) {
                    sb.append(one);
                }
            }
        }
        return new String(sb);
    }
}
