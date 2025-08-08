package sorting11;

class Selectionsort {
	public static void main(String args[]) {
		int arr[] = { 72, 50, 10, 44, 20 };
		selectionSort(arr);
		System.out.println("Sorted array");
		printArray(arr);
	}

	static void selectionSort(int a[]) {
		int len = a.length;
		for (int i = 0; i < len - 1; i++) {
			int min = i;
			for (int j = i + 1; j < len; j++)
				if (a[j] < a[min])
					min = j;
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
	}

	static void printArray(int a[]) {
		int len = a.length;
		for (int i = 0; i < len; ++i)
			System.out.print(a[i] + " ");

		System.out.println();
	}
}
