package leetcode.one_fifty;

public class A_44_WildcardMatching {
    public static void main(String[] args) {
        String s = "a";
        String p = "?";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        StringBuilder sb = new StringBuilder();
        boolean previousStar = false;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                if (previousStar == false) {
                    previousStar = true;
                    sb.append(p.charAt(i));
                }
            } else {
                previousStar = false;
                sb.append(p.charAt(i));
            }
        }
        String pattern = sb.toString();
        boolean[][] arr = new boolean[s.length() + 1][pattern.length() + 1];
        arr[0][0] = true;
        if(!pattern.isEmpty() && pattern.charAt(0) =='*') arr[0][1] = true;
        return isMatchHelper(s, pattern, arr);
    }

    public static boolean isMatchHelper(String s, String p, boolean[][] arr) {
        if (p.isEmpty()) return s.isEmpty();
        if (s.isEmpty()) return p.equals("*");
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    arr[i][j] = arr[i-1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    arr[i][j] = arr[i][j - 1] || arr[i - 1][j];
                }
            }
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }
}
