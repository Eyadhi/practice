package sorting11;

public class InsertionSort {
	public static void insertion(int a1[]) {
		for (int i = 0; i < a1.length; i++) {
			int j = i - 1;
			int b = a1[i];
			while (j >= 0 && b <= a1[j]) {
				a1[j + 1] = a1[j];
				j = j - 1;
			}
			a1[j + 1] = b;
		}
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[] = new int[] { 3, 4, 2, 5, 7, 3 };
		insertion(a1);
	}
}
