package sorting11;

public class quicking {
	static void QuickSort(int a1[], int beg, int end) {
		if (beg < end) {
			int mid = partition(a1, beg, end);
			QuickSort(a1, beg, mid - 1);
			QuickSort(a1, mid + 1, end);
		}
	}

	static int partition(int a1[], int beg, int end) {
		int pivot = a1[end];
		int i = beg - 1;
		for (int j = beg; j < end; j++) {
			if (a1[j] <= pivot) {
				i++;
				int swap = a1[i];
				a1[i] = a1[j];
				a1[j] = swap;
			}
		}
		int swap = a1[i + 1];
		a1[i + 1] = a1[end];
		a1[end] = swap;
		return i + 1;

	}

	public static void main(String[] args) {
		int a1[] = { 3, 4, 2, 5, 7, 3 };
		QuickSort(a1, 0, a1.length - 1);
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + " ");
		}
	}

}
