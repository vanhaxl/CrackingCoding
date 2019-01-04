package leetcode.three00_three50;

public class A_340_LongestSubstringwithAtMostKDistinctCharacters {

    public static void main(String[] args) {
        String s = "ccaabbb";
        int k = 2;

        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.isEmpty() || k < 1) return 0;
        int len = s.length();
        char[] arr = s.toCharArray();
        int max = 0;
        int count = 0;
        int[] counter = new int[128];
        int left = 0, right = 0;
        while(right < len){
            char cur = arr[right++];
            counter[cur]++;
            if(counter[cur] == 1) count ++;

            while(count > k){
                counter[arr[left]] --;
                if(counter[arr[left]] == 0) count --;
                left ++;

            }
            max = Math.max(max, right -left);
        }
        return max;
    }


}
