package leetcode.a_1000_a_1050;

public class A_1006_ClumsyFactorial {
    public static void main(String[] args) {
        System.out.println(clumsy(10));
    }

    public static int clumsy(int n) {
        int originalN = n;
        int result = 0;
        int i = 1;
        if (n <= 2) return n;
        if (n == 3) return 6;
        result = n * (n-1) / (n-2);
        n -= 2;
        int tmp = -1;
        for (i = 4; i <= originalN; i++) {
            if (i % 4 == 0) {
                result += --n;
            } else if (i % 4 == 1) {
                tmp = --n;
            } else if (i % 4 == 2) {
                tmp *= --n;
            } else if (i % 4 == 3) {
                tmp /= --n;
                result -= tmp;
                tmp = -1;
            }
        }
        if (tmp != -1) {
            result -= tmp;
        }

        return result;
    }
}
