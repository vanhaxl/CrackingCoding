package leetcode.three00_three50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A_347_TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};

        System.out.println(topKFrequent(nums, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        map.entrySet().stream().sorted(Map.Entry.comparingByValue((a, b) -> (b - a))).forEach(x -> {
                    if (list.size() < k)
                        list.add(x.getKey());
                }
        );
        return list;
    }
}

/*
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
 */
