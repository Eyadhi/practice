package Sliding_window;

public class Sliding_window {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int left = 0, count = 0;
        long product = 1;

        for (int right = 0; right < n; right++) {
            product *= nums[right];
            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 10, 5, 2, 6 };
        System.out.println(numSubarrayProductLessThanK(nums, 100));
    }
}
