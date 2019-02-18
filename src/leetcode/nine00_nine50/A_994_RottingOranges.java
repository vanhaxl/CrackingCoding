package leetcode.nine00_nine50;

public class A_994_RottingOranges {
	public static void main(String[] args) {
		// int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};//4

		//int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }; //-1
		
		int[][] grid = {{0,2}};
		System.out.println(orangesRotting(grid));
	}

	public static int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int target = 0;
		int count = 0;

		int tmpTarget = 0;
		int preTarget = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 0) {
					target++;
					if(grid[i][j] == 2) {
						tmpTarget ++;
					}
				}
				
			}
		}
		
		while (tmpTarget != target) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 2) {
						if (i + 1 < m && grid[i + 1][j] == 1) {
							grid[i + 1][j] = 3;
						}
						if (i - 1 >= 0 && grid[i - 1][j] == 1) {
							grid[i - 1][j] = 3;
						}

						if (j + 1 < n && grid[i][j + 1] == 1) {
							grid[i][j + 1] = 3;
						}

						if (j - 1 >= 0 && grid[i][j - 1] == 1) {
							grid[i][j - 1] = 3;
						}
					}
				}
			}
			preTarget = tmpTarget;
			tmpTarget = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 2 || grid[i][j] == 3) {
						tmpTarget++;
						grid[i][j] = 2;
					}
				}
			}
			if (tmpTarget == preTarget) {
				return -1;
			}
			count++;
		}

		return count;
	}

}
