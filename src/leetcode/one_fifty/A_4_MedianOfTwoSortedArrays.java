package leetcode.one_fifty;

public class A_4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int[] arr2 = {3, 5, 6, 7};
        System.out.println(findMedianSortedArrays(arr, arr2)); //1, 2, 3, 4, 5, 5, 6, 7
    }

    public static double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        if (m > n) {
            int[] temp = a;
            a = b;
            b = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin < iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if (i < iMax && b[j - 1] > a[i]) { // i is too small. try to make a[i] > b[j-1]
                iMin = i + 1;

            } else if (i > iMin && a[i - 1] > b[j]) { //is is to big. try to make a[i-1] < b[j]
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) maxLeft = b[j - 1];
                else if (j == 0) maxLeft = a[i - 1];
                else maxLeft = Math.max(a[i - 1], b[j - 1]);
                if ((m + n) % 2 == 1) return maxLeft;

                int minRight = 0;
                if (i == m) minRight = b[j];
                else if (j == n) minRight = a[i];
                else minRight = Math.min(a[i], b[j]);
                return (maxLeft + minRight)*1.0 / 2.0;
            }

        }
        return 0.0;

    }
}

/*
The idea behind this problem is: separate A become 2 array, B become 2 array in the way that number of element on
the left is the same or greater than the right 1.
so, the result will be the maxLeft if (m+n) is odd
or (maxLeft + minRight)/2 if (m+n) is even.
complexity: O(log(min(m, n))
 */
