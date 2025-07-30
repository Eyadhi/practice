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
				swap(a1, i, j);
			}
		}
		swap(a1, i + 1, end);
		return i + 1;

	}

	public static void quickSortMiddle(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			int pivot = arr[mid]; // Use mid as pivot without moving

			int i = low;
			int j = high;

			while (i <= j) {
				while (arr[i] < pivot)
					i++;
				while (arr[j] > pivot)
					j--;

				if (i <= j) {
					swap(arr, i, j);
					i++;
					j--;
				}
			}

			// Recursively sort the two partitions
			if (low < j)
				quickSortMiddle(arr, low, j);
			if (i < high)
				quickSortMiddle(arr, i, high);
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int a1[] = { 3, 4, 2, 5, 7, 3 };
		QuickSort(a1, 0, a1.length - 1);
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + " ");
		}
		System.out.println();

		int[] arr = { 10, 7, 8, 9, 1, 5 };
		quickSortMiddle(arr, 0, arr.length - 1);

		System.out.println("Sorted array:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

}
