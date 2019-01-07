package zzz.test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        };
        TreeSet<Integer> set = new TreeSet<>(comparator);
        set.add(3);
        set.add(6);
        set.add(0);
        System.out.println(set.first());
    }
}
