package leetcode.fiftyone_onehundres;

public class A_79_WordSearch {
	public static void main(String[] args) {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//
//        String word = "ABCCED";

		char[][] board = { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
		String word = "AAB";
		System.out.println(exist(board, word));
	}

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			return word == null || word.isEmpty();
		if (word == null || word.isEmpty())
			return true;
		char[] arr = word.toCharArray();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == arr[0]) {
					if (dfs(board, arr, i, j, 0))
						return true;
				}
			}
		}
		return false;

	}

	public static boolean dfs(char[][] board, char[] arr, int i, int j, int start) {
		if (start >= arr.length) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != arr[start]) {
			return false;
		}
		char tmp = board[i][j];
		board[i][j] = '.';
		boolean result = dfs(board, arr, i + 1, j, start + 1) || dfs(board, arr, i - 1, j, start + 1)
				|| dfs(board, arr, i, j + 1, start + 1) || dfs(board, arr, i, j - 1, start + 1);
		board[i][j] = tmp;
		return result;
	}
}
