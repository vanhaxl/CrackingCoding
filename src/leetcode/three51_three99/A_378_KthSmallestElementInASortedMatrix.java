package leetcode.three51_three99;

public class A_378_KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};
        System.out.println(kthSmallest(matrix, 8)); //13
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) { // i theo so row, j column tu right -> left, dem so element
                while(j >= 0 && matrix[i][j] > mid) j--; // ma nho hon mid
                count += (j + 1);
            }
            if(count < k) lo = mid + 1; // neu so element nho hon mid it hon k, lo = mid + 1
            else hi = mid;
        }
        return lo;
    }
}

/*
dung Binary search in space.
 */
