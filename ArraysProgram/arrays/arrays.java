package arrays;

import java.util.*;

public class arrays {
	public static int[] reversing(int nums[], int left, int right) {
		while (left < right) {
			for (int i = 0; i < nums.length / 2; i++) {
				int temp = nums[left];
				nums[left++] = nums[right];
				nums[right--] = temp;
				// left++;
				// right--;
			}
		}
		return nums;
	}

	static int[] rotate(int nums[], int k) {
		k = k % nums.length;
		int a = nums.length - k;
		reversing(nums, 0, a - 1);
		reversing(nums, a, nums.length - 1);
		reversing(nums, 0, nums.length - 1);
		return nums;
	}

	static int secsmallest(int nums[]) {
		int min = nums[0];
		int smin = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < min) {
				smin = min;
				min = nums[i];
			} else if (nums[i] < smin && nums[i] != min) {
				smin = nums[i];
			}
		}
		return smin;
	}

	public int[] seclargest(int nums[]) {
		if (nums.length == 0) {
			return new int[] { -1, -1 };
		}
		int max = nums[0];
		int smax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				smax = max;
				max = nums[i];
			} else if (nums[i] > smax && nums[i] != max) {
				smax = nums[i];
			}
		}
		if (smax == nums[0]) {
			return new int[] { max, -1 };
		}
		return new int[] { max, smax };
	}

	public static int thirdLargest(int[] arr) {
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (first < arr[i]) {
				third = second;
				second = first;
				first = arr[i];
			} else if (second < arr[i] && arr[i] != first) {
				third = second;
				second = arr[i];

			} else if (third < arr[i] && arr[i] != second) {
				third = arr[i];
			}
		}
		return third;
	}

	public static int thirdSmallest(int[] arr) {
		if (arr.length < 3) {
			return -1; // Not enough elements for a third smallest
		}
		// Initialize three variables to hold the first, second, and third smallest
		// values
		// Use Integer.MAX_VALUE to ensure any element in the array will be smaller
		// initially
		// This will help in finding the third smallest element
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		int third = Integer.MAX_VALUE;
		// Iterate through the array to find the first, second, and third smallest
		// elements
		// Update the first, second, and third smallest values accordingly
		for (int i = 0; i < arr.length; i++) {
			// If the current element is smaller than the first smallest, update all three
			// smallest values
			// If the current element is smaller than the second smallest, update second and
			// third
			// smallest values
			// If the current element is smaller than the third smallest, update third
			// smallest
			// value only if it is not equal to the second smallest
			// This ensures that we do not count duplicates for the second and third
			// smallest
			// elements
			if (arr[i] < first) {
				third = second;
				second = first;
				first = arr[i];
			} else if (arr[i] < second && arr[i] != first) {
				third = second;
				second = arr[i];
			} else if (arr[i] < third && arr[i] != second) {
				third = arr[i];
			}
		}
		return third;
	}

	public static int[] twoSum(int[] nums, int target) {
		// Create a map to store the numbers and their indices
		Map<Integer, Integer> map = new HashMap<>();

		// Iterate through the array
		for (int i = 0; i < nums.length; i++) {
			// Calculate the complement
			int complement = target - nums[i];

			// Check if the complement exists in the map
			if (map.containsKey(complement)) {
				// If it exists, return the indices
				return new int[] { map.get(complement), i };
			}

			// Otherwise, add the current number and its index to the map
			map.put(nums[i], i);
		}

		// If no solution is found, return an empty array
		return new int[0];
	}

	public int[] moveZeroes(int[] nums) {
		int lastNonZeroFoundAt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[lastNonZeroFoundAt++] = nums[i];
			}
		}
		for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
			nums[i] = 0;
		}
		return nums;
	}

	public int[] nextGreater(int[] arr) {
		int[] result = new int[arr.length];
		Stack<Integer> s1 = new Stack<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (!s1.isEmpty()) {
				while (!s1.isEmpty() && s1.peek() <= arr[i]) {
					s1.pop();
				}
			}
			if (s1.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = s1.peek();
			}
			s1.push(arr[i]);
		}
		return result;
	}

	public static int missingNumber(int nums[]) {
		int n = nums.length + 1;
		int sum = n * (n + 1) / 2;
		for (int i = 0; i < n - 1; i++) {
			sum -= nums[i];
		}
		return sum;
	}

	public static int[] sortArray(int[] arr) {
		int i = 0;
		int j = 0;
		int k = arr.length - 1;
		while (i <= k) {
			if (arr[i] == 0) {
				swap(arr, i, j);
				i++;
				j++;
			} else if (arr[i] == 1) {
				i++;
			} else {
				swap(arr, i, k);
				k--;
			}
		}
		return arr;
	}

	static int[] sortSquarred(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		int i = 0, j = n - 1;
		for (int k = n - 1; k >= 0; k--) {
			if (Math.abs(arr[i]) > Math.abs(arr[j])) {
				res[k] = arr[i] * arr[i];
				i++;
			} else {
				res[k] = arr[j] * arr[j];
				j--;
			}
		}
		return res;
	}

	static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int findMinimumArraySum(int[] arr) {
		int sum = 0;
		int n = arr.length;

		// Calculate the average of all elements
		double average = 0;
		for (int num : arr) {
			average += num;
		}
		average /= n;

		// Update elements less than average to 0
		for (int i = 0; i < n; i++) {
			if (arr[i] < average) {
				arr[i] = 0;
			}
			sum += arr[i];
		}

		return sum;
	}

	public static int tripletDivisible(int[] arr, int d) {
		int count = 0;
		HashMap<Integer, Integer> h1 = new HashMap<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int x = (d - (arr[i] + arr[j]) % d) % d;
				count += h1.getOrDefault(x, 0);
			}
			h1.merge(arr[i] % d, 1, Integer::sum);
		}
		return count;
	}

	public static void swapArray(int arr[]) {
		int i = 0;
		while (i < arr.length - 1) {
			int swap = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = swap;
			i += 2;
		}
	}

	public static void sortDescArray(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	static int equilibrium(int arr[]) {
		int n = arr.length;
		int left_sum = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		for (int i = 0; i < n; i++) {
			sum -= arr[i];
			if (left_sum == sum) {
				return i + 1;
			}
			left_sum += arr[i];
		}
		return -1;
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	static int FindGcd(int nums[], int n) {
		int result = nums[0];
		for (int i = 1; i < n; i++) {
			result = gcd(result, nums[i]);
		}
		return result;
	}

	public static void frequencyCount(int arr[], int N, int P) {
		int res[] = new int[N + 1];
		Map<Integer, Integer> h1 = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			if (h1.containsKey(arr[i])) {
				h1.put(arr[i], h1.get(arr[i]) + 1);
			} else {
				h1.put(arr[i], 1);
			}
		}
		System.out.println(h1);
		for (int i = 1; i <= N; i++) {
			res[i] = h1.containsKey(i) ? h1.get(i) : 0;
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(res[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int nums[]= {1,4,3,2,5};
		 * Arrays.sort(nums);
		 * Arrays.reverse(nums);
		 * //int result[]=reversing(nums);
		 * for(int i=0;i<nums.length;i++) {
		 * System.out.print(nums[i]+" ");
		 * }
		 * 
		 * System.out.println("second largest: "+seclargest(nums));
		 * System.out.println("second smallest: "+secsmallest(nums));
		 * System.out.println(thirdLargest(nums));
		 * System.out.println(thirdSmallest(nums));
		 * 
		 * int nums[]= {1,2,3,4,5,6,7};
		 * int result[]=rotate(nums,3);
		 * for(int i=0;i<nums.length;i++) {
		 * System.out.print(result[i]+" ");
		 * }
		 * 
		 * arr[]= {1,4,2,9,5};
		 * System.out.println( findMinimumArraySum(arr));
		 * 
		 * int arr[]= {14,2,5,1,3,4,1};
		 * System.out.println(equilibrium(arr));
		 * 
		 * String[] val= {"4","13","5","/","+"};
		 * System.out.println(reverse_polish(val));
		 * 
		 * /*int arr[]= {4,7,3,4,8,1};
		 * int[] arr1=n1.nextGreater(arr);
		 * for(int i=0;i<arr.length;i++) {
		 * System.out.print(arr1[i]+" ");
		 * }
		 * System.out.println();
		 * 
		 * int arr2[]= {1,0,2,0,2,1,0,1,2,1,0};
		 * int res[]=sortArray(arr2);
		 * for(int i=0;i<arr2.length;i++) {
		 * System.out.print(res[i]+" ");
		 * }
		 * System.out.println();
		 * 
		 * int arr3[]= {-4,-1,0,2,4,10};
		 * int res1[]=sortSquarred(arr3);
		 * for(int i=0;i<arr3.length;i++) {
		 * System.out.print(res1[i]+" ");
		 * }
		 * System.out.println();
		 * 
		 * int nums[]= {1,2,4,5,6};
		 * System.out.println(missingNumber(nums));
		 * 
		 * int nums1[]= {2,4,6,8,10};
		 * int res2=FindGcd(nums1,nums1.length);
		 * System.out.print(res2);
		 * 
		 * int arr1[]= {1,2,3,4,5,6};
		 * int d=5;
		 * System.out.println(tripletDivisible(arr1,d));
		 */

		int[] arr1 = { 3, 6, 4, 7, 8, 9 };
		swapArray(arr1);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}

		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] result = twoSum(nums, target);
		if (result.length == 2) {
			System.out.println("Indices: " + result[0] + ", " + result[1]);
		} else {
			System.out.println("No two sum solution found.");
		}
	}
}
