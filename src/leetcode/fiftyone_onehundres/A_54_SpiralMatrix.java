package leetcode.fiftyone_onehundres;

import java.util.ArrayList;
import java.util.List;

public class A_54_SpiralMatrix {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(spiralOrder(arr));
	}



	public static List<Integer> spiralOrder(int[][] arr) {
		List<Integer> list = new ArrayList<>();
		if (arr == null || arr.length == 0 || arr[0].length == 0)
			return list;
		// k start row
		// l start col
		// m row
		// n cols
		int r = 0, c = 0, m = arr.length, n = arr[0].length;
		while (r < m && c < n) {
			for (int i = c; i < n; i++) { // go right
				list.add(arr[r][i]);
			}
			r++;
			for (int i = r; i < m; i++) { // go down
				list.add(arr[i][n - 1]);
			}
			n--;
			if (r < m) {
				for (int i = n - 1; i >= c; i--) { // go left
					list.add(arr[m - 1][i]);
				}
				m--;
			}
			if (c < n) {
				for (int i = m - 1; i >= r; i--) { // go up
					list.add(arr[i][c]);
				}
				c++;
			}
		}
		return list;
	}
}
