package zzz.test;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Set<Character> set = new HashSet<>();
        set.add('4');
        System.out.println(set.contains('4'));
    }
}
