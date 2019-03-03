package leetcode.a_1000_a_1050;

import java.util.ArrayList;
import java.util.List;

public class A_1002 {
    public static void main(String[] args) {
        String[] a = {"bella", "label", "roller"};
        System.out.println(commonChars(a));
    }

    public static List<String> commonChars(String[] arr) {

        int len = arr.length;
        int[][] a = new int[len][26];
        for (int i = 0; i < len; i++) {
            char[] charArr = arr[i].toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                a[i][charArr[j] - 'a']++;
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                min = Math.min(min, a[j][i]);
            }
            char tmp = (char) (i + 'a');
            for (int k = 0; k < min; k++) {
                result.add(tmp + "");
            }
        }
        return result;

    }


}
