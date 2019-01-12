package leetcode.one00_one50;

import java.util.ArrayList;
import java.util.List;

public class A_131_PalindromePartitioning {
    public static  void main(String[] args){

    }

    public static List<List<String>> partition(String s){
        List<List<String>> list = new ArrayList<>();
        for(int i = 0; i< s.length(); i++){
            search(list, s, new StringBuilder(s.charAt(i)), i-1, i+1);
        }
        return list;
    }

    public static void search(List<List<String>> list, String s, StringBuilder sb, int l, int r){

    }
}
