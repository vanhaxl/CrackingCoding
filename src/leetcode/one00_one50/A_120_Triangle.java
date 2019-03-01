package leetcode.one00_one50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_120_Triangle {
    public static void main(String[] args) {
//        List<Integer> l1 = new ArrayList(Arrays.asList(2));
//        List<Integer> l2 = new ArrayList(Arrays.asList(3, 4));
//        List<Integer> l3 = new ArrayList(Arrays.asList(6, 5, 7));
//        List<Integer> l4 = new ArrayList(Arrays.asList(4, 1, 8, 3));
//
//        List<List<Integer>> list = new ArrayList<>();
//        list.add(l1);
//        list.add(l2);
//        list.add(l3);
//        list.add(l4);

        List<Integer> l1 = new ArrayList(Arrays.asList(-1));
        List<Integer> l2 = new ArrayList(Arrays.asList(2, 3));
        List<Integer> l3 = new ArrayList(Arrays.asList(1, -1, -1));

        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);

        System.out.println(minimumTotal(list));

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] arr = new int[triangle.size() + 1];//as we want to do a[i] = min(a[i], a[i+1]) for the longest row
        for(int i = triangle.size() -1; i>= 0; i--){
            for(int j = 0; j< triangle.get(i).size(); j++){
                arr[j] = Math.min(arr[j], arr[j+1])+ triangle.get(i).get(j);
            }
        }
        return arr[0];
    }
}


/*
dp[n]: max from line 0 to line n
store a temp array is better than one value
 */
/*
For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
