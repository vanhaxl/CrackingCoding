package zzz.test;

import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
	public static void main(String[] args) {
		System.out.println((int) (Math.log(10) / Math.log(3)));
		// System.out.println(brokenCalc(x, y));
	}

	public static int brokenCalc(int x, int y) {
		if (x == y)
			return 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int tmp = queue.poll();
				if (tmp == y)
					return count;
				else if (tmp < y) {
					if (tmp >= y / 2)
						queue.add(tmp - 1);
					queue.add(tmp * 2);
				} else {
					return count + tmp - y;
				}
			}
			count++;
		}
		return count;
	}
}
