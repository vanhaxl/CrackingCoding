package leetcode.one_fifty;

public class A_6_ZigZagConversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		System.out.println(convert(s, 4));
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		StringBuilder[] arr = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			arr[i] = new StringBuilder("");
		}
		int direction = -1;
		int row = 0;
		for (int i = 0; i < s.length(); i++) {
			arr[row].append(s.charAt(i));
			if (row == 0 || row == numRows - 1) {
				direction *= -1;
			}
			row += direction;
		}
		return String.join("", arr);
	}

}
