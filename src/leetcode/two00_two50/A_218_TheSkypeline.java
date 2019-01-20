package leetcode.two00_two50;

import java.util.*;

public class A_218_TheSkypeline {
    public static void main(String[] args) {
        int[][] arr = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<int[]> result = getSkyline(arr);
        result.forEach(a -> System.out.println(Arrays.toString(a)));

    }

    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>(); // element of height is just (x, y) not like in building(x0,x1,y)

        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]}); // start, make y is -
            height.add(new int[]{b[1], b[2]});  // end
        }

        Collections.sort(height, (a, b) -> { // sort by x, then by y
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> (b - a));  //max heap
        priorityQueue.add(0);
        int pre = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                priorityQueue.add(-h[1]);
            } else {
                priorityQueue.remove(h[1]);
            }
            int cur = priorityQueue.peek(); // max heap is used to store y, height of the building
            if (pre != cur) { // if max change, add to result
                result.add(new int[]{h[0], cur});
                pre = cur;
            }
        }
        return result;
    }
}

// happen at start or end of building
// First we need to convert (x1, x2, y) become (x1, y) //start, (x2, y)//end
// add start at (x1, -y) in order to handle special case:
// enter start: push height to max heap. if max change, add to result
// enter end: remove height from max heap. if max change, add to result.
//special case:
// - same x at start: larger y first
// - same x at end: smaller y first
// - x end = x start: start before end.
