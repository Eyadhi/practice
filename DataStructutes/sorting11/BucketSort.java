package sorting11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    static void bucketSort(int[] arr) {
        int n = arr.length;

        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            if (min > num)
                min = num;
            if (max < num)
                max = num;
        }

        int bucketCount = ((max - min) / n) + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : arr) {
            int index = (num - min) / n;
            buckets.get(index).add(num);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    static void printArray(int a[]) {
        int len = a.length;
        for (int i = 0; i < len; ++i)
            System.out.print(a[i] + " ");

        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 42, 32, 23, 52, 25, 47, 51, 99, 8, 17 };
        bucketSort(arr);
        System.out.println("Sorted array");
        printArray(arr);

    }
}
