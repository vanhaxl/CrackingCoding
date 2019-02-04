package zzz.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        for (int i = 0; i < 5000000; i++) {
//            set.add("1234567890123456" + i);
//        }
//
//        List<String> result = new ArrayList<>();
//
//
//        for (int i = 0; i < 5000000; i++) {
//            if(set.contains("1234567890123456" + i))
//                result.add("1234567890123456" + i);
//        }
//
//        for (String x : set) {
//            System.out.println(x);
//        }
//
//        System.out.println(result.size());

//        String s = "40000000009902446999100000000000000006279000000000000000000000104077771692000000400460+0000010000        2019030094515000000000000000000000000000000000                         0000000000N                                                        0000000000000000840               0059                                                                                                                                                                                    00000000000000137681775154800076                                                                                                          ";
//        System.out.println(s.substring(475, 493));

        List<String> list = new ArrayList<>();
        list.add("van");
        list.add("ha");
        list.add("nguyen");
        list.add(0, "abc");
        System.out.println(list.toString());
    }
}
