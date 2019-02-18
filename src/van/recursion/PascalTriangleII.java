package van.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        int[] arr = new int[1];
        arr[0] = 1;
        for (int i = 0; i < rowIndex; i++) {
            int[] newArr = new int[arr.length + 1];
            newArr[0] = 1;
            newArr[newArr.length - 1] = 1;
            int l = 1, r = newArr.length - 2;
            while (l <= r) {
                newArr[l] = arr[l - 1] + arr[l];
                newArr[r] = arr[r - 1] + arr[r];
                l++;
                r--;
            }
            arr = newArr;
        }
        List<Integer> result = new ArrayList<>();
        for (int x : arr) {
            result.add(x);
        }
        return result;
    }

}

/*
time: n^2
space: n
 */

/*
Input: 3
Output: [1,3,3,1]

Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
