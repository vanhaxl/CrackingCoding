package leetcode.two00_two50;

import java.util.*;

public class A_239_SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
    }

//    public static int[] maxSlidingWindow(int[] arr, int k) {
//        if (arr == null || arr.length == 0 || k == 0) return new int[0];
//        int len = arr.length;
//        int[] result = new int[len - k + 1];
//        int index = 0;
//
//        Queue<Integer> q = new LinkedList<>();
//        for (int i = 0; i < arr.length; i++) {
//            if (q.size() < k) {
//                q.add(arr[i]);
//            }
//            if (i >= k-1) {
//                result[index++] = findMaxInQueue(q);
//                q.remove();
//            }
//        }
//        return result;
//    }
//
//    public static int findMaxInQueue(Queue<Integer> queue) {
//        int max = Integer.MIN_VALUE;
//        for (int x : queue) {
//            max = Math.max(max, x);
//        }
//        return max;
//    }

    public static int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
}
