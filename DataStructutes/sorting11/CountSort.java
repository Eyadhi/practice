package sorting11;

public class CountSort {
    public static void main(String args[]) {
        int arr[] = { 1, 5, 10, 2, 5, 3, 2, 1, 10, 5 };
        countSort(arr);
        System.out.println("Sorted array");
        printArray(arr);

        int[] nums = { 72, 20, 44, 50, 72 };
        countSort(nums);

        // Output
        System.out.println("Sorted array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    static void countSort(int nums[]) {
        int len = nums.length;
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int[] count = new int[max + 1];

        // Count occurrences
        for (int num : nums) {
            count[num]++;
        }

        // Reconstruct the sorted array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i]-- > 0) {
                nums[index++] = i;
            }
        }

        // for (int i = 1; i <= maxi; i++) {
        // count[i] += count[i - 1];
        // }
        // int[] ans = new int[len];
        // for (int i = len - 1; i >= 0; i--) {
        // ans[count[a[i]] - 1] = a[i];
        // count[a[i]]--;
        // }
        // for (int i = 1; i < len; i++) {
        // a[i] = ans[i];
        // }
    }

    static void printArray(int a[]) {
        int len = a.length;
        for (int i = 0; i < len; ++i)
            System.out.print(a[i] + " ");

        System.out.println();
    }
}
