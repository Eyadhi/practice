package sorting11;

public class Mergesort {
	static void mergesorting(int a2[], int beg, int end) {
		if (beg < end) {
			int mid = (beg + end) / 2;
			mergesorting(a2, beg, mid);
			mergesorting(a2, mid + 1, end);
			merge(a2, beg, mid, end);
		}
	}

	static void merge(int a2[], int beg, int mid, int end) {
		int i, j, k;
		int l1[] = new int[mid - beg + 1];
		int r1[] = new int[end - mid];
		for (i = 0; i < l1.length; i++) {
			l1[i] = a2[beg + i];
		}
		for (j = 0; j < r1.length; j++) {
			r1[j] = a2[mid + 1 + j];
		}
		i = 0;
		j = 0;
		k = beg;
		while (i < l1.length && j < r1.length) {
			if (l1[i] < r1[j]) {
				a2[k] = l1[i];
				i++;
			} else {
				a2[k] = r1[j];
				j++;
			}
			k++;
		}
		while (i < l1.length) {
			a2[k] = l1[i];
			i++;
			k++;
		}
		while (j < r1.length) {
			a2[k] = r1[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		int a2[] = new int[] { 2, 1, 4, 6, 1, 8, 1 };
		mergesorting(a2, 0, (a2.length) - 1);
		for (int i = 0; i < a2.length; i++) {
			System.out.print(a2[i] + " ");
		}

	}

}
