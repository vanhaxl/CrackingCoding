package leetcode.fiftyone_onehundres;

public class A_76_MinimumWindowSubstring {
    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "AABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t){
        int[] arr = new int[128];
        int left = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";

        for(int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)]++;
        }

        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]--;
            if(arr[s.charAt(i)] >= 0) count++;
            while(count == t.length()) {
                if(minLen > i - left + 1) {
                    minLen = i - left + 1;
                    result = s.substring(left, left+minLen);
                }
                arr[s.charAt(left)]++;
                if(arr[s.charAt(left)] > 0) count--;
                left++;
            }
        }
        return result;
    }



}
