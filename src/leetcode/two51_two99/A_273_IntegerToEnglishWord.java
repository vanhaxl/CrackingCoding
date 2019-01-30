package leetcode.two51_two99;

public class A_273_IntegerToEnglishWord {

    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static void main(String[] args) {
        int n = 1000; //One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven
        System.out.println(numberToWords(n));
    }

    public static String numberToWords(int n) {
        if (n == 0) return "Zero";
        int i = 0;
        String result = "";
        while (n > 0) {
            if (n % 1000 != 0)
                result = helper(n % 1000) + THOUSANDS[i] + " " + result;
            n = n / 1000;
            i++;
        }
        return result.trim();
    }

    public static String helper(int n) { // this n is always less than 1000
        if (n == 0) return "";
        if (n < 20) return LESS_THAN_20[n] + " ";
        if (n < 100) return TENS[n / 10] + " " + helper(n % 10);
        else return LESS_THAN_20[n / 100] + " Hundred " + helper(n % 100);
    }
}
