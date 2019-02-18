package van.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, n, 1);
        return result;
    }

    public static void helper(List<List<Integer>> result, int n, int curLength) {
        if (curLength > n) return;
        if (curLength == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
            helper(result, n, curLength + 1);
        } else {
            List<Integer> lastList = new ArrayList<>(result.get(result.size() - 1));
            lastList.add(0, 0);
            lastList.add(lastList.size(), 0);

            int[] arr = lastList.stream().mapToInt(i->i).toArray();

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < arr.length-1; i++) {
                list.add(arr[i] + arr[i+1]);
            }
            result.add(list);
            helper(result, n, curLength + 1);
        }
    }

}

/*
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
