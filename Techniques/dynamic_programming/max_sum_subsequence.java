package dynamic_programming;

public class max_sum_subsequence {
	public static int sequence(int a[]) {
		int pre1 = a[0];
		int pre2 = Math.max(a[0], a[1]);
		for (int i = 2; i < a.length; i++) {
			int temp = pre2;
			pre2 = Math.max(pre1 + a[i], pre2);
			pre1 = temp;
		}
		return pre2;
	}

	public static int maxsubArray(int[] arr) {
		int max = arr[0];
		int newsum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			newsum = Math.max(arr[i], newsum + arr[i]);
			max = Math.max(max, newsum);
		}
		return max;
	}

	public static int maxProductSub(int arr[]) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int maxlocal = arr[0];
		int minlocal = arr[0];
		int global = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int temp = maxlocal;
			maxlocal = Math.max(Math.max(arr[i] * maxlocal, arr[i]), arr[i] * minlocal);
			minlocal = Math.min(Math.min(arr[i] * temp, arr[i]), arr[i] * minlocal);
			global = Math.max(maxlocal, global);
		}
		return global;
	}

	public static int removeDuplicates(int arr[]) {
		if (arr.length <= 2)
			return arr.length;
		int prev = 1;
		int curr = 2;
		while (curr < arr.length) {
			if (arr[curr] == arr[prev] && arr[curr] == arr[prev - 1]) {
				curr++;
			} else {
				prev++;
				arr[prev] = arr[curr];
				curr++;
			}
		}
		return prev + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 2, 3, -2, 4 };
		int result = sequence(a);
		System.out.println(result);
		System.out.println(maxsubArray(a));
		System.out.println(maxProductSub(a));
		int[] arr = { 1, 1, 1, 2 };
		System.out.println(removeDuplicates(arr));
	}
}
