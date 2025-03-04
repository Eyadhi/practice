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

	static int reverse_polish(String[] val) {
		Stack<String> s1 = new Stack<>();
		int res = 0;
		String operators = "*+-/";
		for (String t : val) {
			if (!operators.contains(t)) {
				s1.push(t);
			} else {
				int a = Integer.valueOf(s1.pop());
				int b = Integer.valueOf(s1.pop());
				switch (t) {
					case "+":
						s1.push(String.valueOf(a + b));
						break;
					case "-":
						s1.push(String.valueOf(b - a));
						break;
					case "*":
						s1.push(String.valueOf(a * b));
						break;
					case "/":
						s1.push(String.valueOf(b / a));
						break;
				}
			}
		}
		res = Integer.valueOf(s1.pop());
		return res;
	}

	static int[] rotate(int nums[], int k) {
		k = k % nums.length;
		int a = nums.length - k;
		reversing(nums, 0, a - 1);
		reversing(nums, a, nums.length - 1);
		reversing(nums, 0, nums.length - 1);
		return nums;

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

	public static int[] Balance(int[] a) {
		int n = a.length;
		int[] r = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
			r[i] = Math.abs(sum - sumR(i + 1, a));
		}
		return r;
	}

	public static int sumR(int j, int[] a) {
		int n = a.length;
		int val = 0;
		for (int i = j; i < n; i++) {
			val += a[i];
		}
		if (j == n) {
			return 0;
		}
		return val;
	}

	static void IsPossible(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		Arrays.sort(arr);
		reversing(arr, 0, arr.length - 1);
		if (sum == 0) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println("Possible");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		}
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
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		int third = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
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

	public static int missing_number(int nums[]) {
		int n = nums.length + 1;
		int sum = n * (n + 1) / 2;
		for (int i = 0; i < n - 1; i++) {
			sum -= nums[i];
		}
		return sum;

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
		 * String a="Babu";
		 * for(int j=a.length()-1;j>=0;j--) {
		 * System.out.print(a.charAt(j));
		 * }
		 * int nums[]= {1,2,3,4,5,6,7};
		 * int result[]=rotate(nums,3);
		 * for(int i=0;i<nums.length;i++) {
		 * System.out.print(result[i]+" ");
		 * }
		 * int a=1600;
		 * if((a%4==0 && a%100!=0)|| a%400==0) {
		 * System.out.println("Leap year");
		 * }
		 * else {
		 * System.out.println("Not Leap year");
		 * }
		 * int arr[]= {1,4,2,9,5};
		 * System.out.println( findMinimumArraySum(arr));
		 * int arr1[]= {2,3,1,5,4};
		 * int N=arr1.length;
		 * int k=3;
		 * System.out.println(findMaxScore(N,k,arr1));
		 * String S = "60004";
		 * int minimumKeyPresses = findMinimumKeyPresses(S);
		 * System.out.println("Minimum number of key presses: " + minimumKeyPresses);
		 * int[] a={1,2,3,4,5};
		 * int[] res=Balance(a);
		 * System.out.println(Arrays.toString(res));
		 * String inputString = "aabbcc";
		 * int result = minStepsToMagicString(inputString);
		 * System.out.println("Minimum number of steps required: " + result);
		 * int initialMarbles = 10; // Initial number of marbles
		 * int[] operations = { 2, 5 }; // Operations: A and B
		 * int uniqueValues = findUniqueValues(initialMarbles, operations);
		 * System.out.println("Total number of unique values: " + uniqueValues);
		 * System.out.println(UniqueMarbles(10,2,5));
		 * int [] a= {2,9,3,4,5};
		 * System.out.println(ponds(a));
		 * System.out.println(BirthDay(2,3));
		 * //System.out.println( pyramidSum(4));
		 * int[] roll = {4,2,1,5,8,9};
		 * int k = 6;
		 * int arr[]= {14,2,5,1,3,4,1};
		 * System.out.println(equilibrium(arr));
		 * int result = findDebatePair(roll, k);
		 * if (result != -1) {
		 * System.out.println("Lowest roll number of the pair with sum divisible by k: "
		 * + result);
		 * }
		 * System.out.println(Security(122245));
		 * String str4="xxxyyz";
		 * System.out.println(UniqueString(str4));
		 * String[] val= {"4","13","5","/","+"};
		 * System.out.println(reverse_polish(val));
		 * /*int arr[]= {4,7,3,4,8,1};
		 * next_greater n1=new next_greater();
		 * int[] arr1=n1.nextGreater(arr);
		 * for(int i=0;i<arr.length;i++) {
		 * System.out.print(arr1[i]+" ");
		 * }
		 * System.out.println();
		 * int arr2[]= {1,0,2,0,2,1,0,1,2,1,0};
		 * int res[]=sortArray(arr2);
		 * for(int i=0;i<arr2.length;i++) {
		 * System.out.print(res[i]+" ");
		 * }
		 * System.out.println();
		 * int arr3[]= {-4,-1,0,2,4,10};
		 * int res1[]=sortSquarred(arr3);
		 * for(int i=0;i<arr3.length;i++) {
		 * System.out.print(res1[i]+" ");
		 * }
		 * System.out.println();
		 * int nums[]= {1,2,4,5,6};
		 * System.out.println(missing_number(nums));
		 * int nums1[]= {2,4,6,8,10};
		 * int res2=FindGcd(nums1,nums1.length);
		 * System.out.print(res2);
		 * System.out.println(secsmallest(nums2));
		 */
		// ArrayList<Integer>l1=new ArrayList<>();
		// l1.add(0);
		// l1.add(2);
		// l1.add(1);
		// l1.add(2);
		// l1.add(0);
		// sort012(l1);
		// System.out.println(l1);
		int[] arr1 = { 3, 6, 4, 7, 8, 9 };
		/*
		 * int d=5;
		 * System.out.println(tripletDivisible(arr1,d));
		 * System.out.println(thirdLargest(arr1));
		 * System.out.println(thirdSmallest(arr1));
		 */
		// IsPossible(arr1);
		swapArray(arr1);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}
}
