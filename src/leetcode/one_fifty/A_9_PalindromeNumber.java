package leetcode.one_fifty;

public class A_9_PalindromeNumber {
    public static void main(String[] args) {
        int a = 121;
        System.out.println(isPalindrome(a));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }

//    public static boolean isPalindrome(int x) {
//        if (x < 0) return false;
//        int range = 1;
//        while (x / range >= 10) {
//            range *= 10;
//        }
//        int l = 0, r = 0;
//        while (x > 0) {
//            l = x / range;
//            r = x % 10;
//            if (l != r) return false;
//            x = x % range / 10;
//            range /= 100;
//        }
//        return true;
//    }
}
