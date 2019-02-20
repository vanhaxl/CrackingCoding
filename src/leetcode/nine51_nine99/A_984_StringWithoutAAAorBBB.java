package leetcode.nine51_nine99;

public class A_984_StringWithoutAAAorBBB {
    public static void main(String[] args) {
        System.out.println(strWithout3a3b(4, 1));
    }

    public static String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while (a != 0 && b != 0) {
            if(a > b){
                sb.append("aa");
                sb.append("b");
                a -= 2;
                b -=1;
            } else if(a < b){
                sb.append("bb");
                sb.append("a");
                b -=2;
                a -=1;
            } else{
                sb.append("a");
                sb.append("b");
                a--;
                b--;
            }
        }
        if(a != 0){
            if(a > 2){
                return "";
            } else if(a == 1){
                sb.append("a");
            } else if(a == 2){
                sb.append("aa");
            }
        }
        if(b != 0){
            if(b > 2){
                return "";
            } else if(b == 1){
                sb.append("b");
            } else if(b == 2){
                sb.append("bb");
            }
        }
        return sb.toString();
    }
}

/*
Given two integers A and B, return any string S such that:

S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
The substring 'aaa' does not occur in S;
The substring 'bbb' does not occur in S.


Example 1:

Input: A = 1, B = 2
Output: "abb"
Explanation: "abb", "bab" and "bba" are all correct answers.
Example 2:

Input: A = 4, B = 1
Output: "aabaa"
 */

/*
a = 3, b = 0 -> ""

a-2 b-1
 */

