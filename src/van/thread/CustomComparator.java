package van.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomComparator {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("partition0");
		list.add("partition10");
		list.add("partition100");
		list.add("partition20");
		list.add("partition10");
		list.add("partition4");
		list.add("partition6");
		list.add("partition1");
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				if (a.length() != b.length())
					return Integer.compare(a.length(), b.length());
				else
					return a.compareTo(b);
			}
		};
		Collections.sort(list, comparator);
		for (String x : list) {
			System.out.println(x);
		}

	}

}
