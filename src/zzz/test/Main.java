package zzz.test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "40000000009902446999100000000000000006279000000000000000000000100177771692000000102105+0000005000        2019051050744000000000000000000000000000000012                         0000000000N                                                        0000000000000000840               005936634                                                                                                                                                                               00000000000001376997526452800680                                                                                                          \n";
        System.out.println(s.substring(461, 493).replaceFirst("^0*", ""));
    }


}
