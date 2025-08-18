package Algorithms.BoyerMooreVotingAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement {
    public static Integer majorityElementn2(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        if (count > nums.length / 2) {
            return candidate; // Majority element exists
        }
        return null;
    }

    public static List<Integer> majorityElementn3(int[] nums) {
        List<Integer> majority = new ArrayList<>();
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                count2 = 1;
                candidate2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
        }

        if (count1 > (nums.length / 3))
            majority.add(candidate1);
        if (count2 > (nums.length / 3))
            majority.add(candidate2);
        return majority;
    }

    public static List<Integer> findElements(int[] nums, int k) {
        Map<Integer, Integer> candidate = new HashMap<>();
        for (int num : nums) {
            if (candidate.containsKey(num)) {
                candidate.put(num, candidate.get(num) + 1);
            } else if (candidate.size() < k - 1) {
                candidate.put(num, 1);
            } else {
                List<Integer> toremove = new ArrayList<>();
                for (Entry<Integer, Integer> entry : candidate.entrySet()) {
                    candidate.put(entry.getKey(), entry.getValue() - 1);
                    if (candidate.get(entry.getKey()) == 0) {
                        toremove.add(entry.getKey());
                    }
                }
                for (int remove : toremove) {
                    candidate.remove(remove);
                }
            }
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (candidate.containsKey(num)) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > (nums.length / k)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(majorityElementn2(nums));

        int[] nums2 = { 1, 2, 3, 1, 2, 1, 2, 3, 3 };
        System.out.println(majorityElementn3(nums2));

        int[] numsk = { 1, 2, 3, 2, 3, 1, 4, 4 };
        int k = 4;
        System.out.println(findElements(numsk, k)); // Output: [1, 2]
    }
}
