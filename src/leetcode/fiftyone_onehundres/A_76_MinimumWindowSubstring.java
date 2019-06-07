package leetcode.fiftyone_onehundres;

public class A_76_MinimumWindowSubstring {
    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
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
            //tai sao >= , t co nhieu C, s co 1 c cung tinh
            // tai vi moi character count tang len, thi tang toi chung nao count = t.length()
            // => chi tinh nhung thang >= 0 , < 0 la du thua o S, ko tinh nua
            if(arr[s.charAt(i)] >= 0) count++; // >= , not > because duplicate (s="aa", t = "aa")?? k dup cung phai >=
            while(count == t.length()) { // substring contains all characters int t
                if(minLen > i - left + 1) {
                    minLen = i - left + 1;
                    result = s.substring(left, left+minLen);
                }
                //move left to right
                arr[s.charAt(left)]++;
                if(arr[s.charAt(left)] > 0) count--;
                left++;
            }
        }
        return result;
    }
}

/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
- Use 2 pointers. left & right
- User int arr[128] in order to store number of character in string t.
- Move right pointer until we have a string that contains all characters in T
- move left if that string still satify, store minLen and tempResult
we loop from 0 -> s.length()-1;

 */
