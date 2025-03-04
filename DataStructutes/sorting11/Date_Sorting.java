package sorting11;

import java.util.*;

public class Date_Sorting {
	static Map<String, Integer> m1 = new HashMap<>();

	static void sortMonths() {
		m1.put("Jan", 1);
		m1.put("Feb", 2);
		m1.put("Mar", 3);
		m1.put("Apr", 4);
		m1.put("May", 5);
		m1.put("Jun", 6);
		m1.put("Jul", 7);
		m1.put("Aug", 8);
		m1.put("Sep", 9);
		m1.put("Oct", 10);
		m1.put("Nov", 11);
		m1.put("Dec", 12);
	}

	static int cmp(String dates) {
		String[] dateParts = dates.split(" ");
		int day = Integer.parseInt(dateParts[0]);
		int month = m1.get(dateParts[1]);
		int year = Integer.parseInt(dateParts[2]);
		return year * 10000 + month * 100 + day;
	}

	static void PrintDates(String[] dates, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(dates[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dates = { "24 Jul 2017", "25 Jul 2017", "11 Jan 1996" };
		int n = dates.length;
		sortMonths();
		Arrays.sort(dates, (a, b) -> cmp(a) - cmp(b));
		PrintDates(dates, n);
	}

}
