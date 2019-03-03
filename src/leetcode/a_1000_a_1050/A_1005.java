package leetcode.a_1000_a_1050;

public class A_1005 {
    public static void main(String[] args) {
        int[] stones = {3, 5, 1, 2, 6};
        System.out.println(mergeStones(stones, 3));
    }

    public static int mergeStones(int[] stones, int k) {
        int len = stones.length;
        if (len == 1) return stones[0];
        if (len > 1 && len < k) return -1;
        int l1 = len / k; // 1
        int l2 = l1 + (len - l1 * k); //3
        int[] arr = new int[l2];
        int lastIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i >= l1 && i < l2) {
                arr[i] = stones[++lastIndex];
            } else {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    sum += stones[j];
                    lastIndex = i * k + j;
                }
                arr[i] = sum;
            }
        }
        return mergeStones(arr, k);
    }

}
