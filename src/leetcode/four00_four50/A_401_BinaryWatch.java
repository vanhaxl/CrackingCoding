package leetcode.four00_four50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_401_BinaryWatch {
    public static void main(String[] args) {
        System.out.println(readBinaryWatch(4));
        //System.out.println(Integer.parseInt("1100", 2));
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        if (num < 0 || num > 10) return list;
        char[] arr = new char[10];
        Arrays.fill(arr, '0');
        backtrack(list, arr, 0, 0, num);

        List<String> result = new ArrayList<>();
        for (String s : list) {
            int hh = Integer.parseInt(s.substring(0, 4), 2);
            int mm = Integer.parseInt(s.substring(4), 2);
            if (hh > 11 || mm > 59) continue;
            result.add(hh + ":" + (mm < 10 ? ("0" + mm) : mm));
        }
        return result;
    }

    public static void backtrack(List<String> result, char[] arr, int start, int count, int num) {
        if (count > num) return;
        if (count == num) {
            result.add(String.valueOf(arr));
        }
        for (int i = start; i < arr.length; i++) {
            arr[i] = '1';
            backtrack(result, arr, i + 1, count + 1, num);
            arr[i] = '0';
        }
    }
}

/*

A binary watch has 4 LEDs on the top which represent the hours (0-11), and
the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.

Given a non-negative integer n which represents the number of LEDs that are currently on,
return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

hhhh:mmmmmm
 *//*
0000
0001
0010
0011
0100
0101
0110
0111
1000
1001
1010
1011
1100
 */