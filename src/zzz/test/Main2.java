package zzz.test;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {

        System.out.println(hammingWeight(0b11111111111111111111111111111101));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while(n!= 0){
            if((n & 1) == 1) count ++;
            n = n>>1;
        }
        return count;
    }
}
