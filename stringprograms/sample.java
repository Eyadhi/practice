package stringprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class sample {
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        Set<Character> s1 = new LinkedHashSet<>();
        for (char ch : str.toCharArray()) {
            if (!s1.contains(ch)) {
                s1.add(ch);
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static Boolean validAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        // Map<Character, Integer> h1 = new HashMap<>();
        // for (char ch : str1.toCharArray()) {
        // h1.put(ch, h1.getOrDefault(ch, 0) + 1);
        // }

        // for (char ch : str2.toCharArray()) {
        // h1.put(ch, h1.getOrDefault(ch, 0) - 1);
        // }
        // for (var pair : h1.entrySet()) {
        // if (pair.getValue() != 0) {
        // return false;
        // }
        // }
        // return true;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int[] count = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++; // increment for str1
            count[str2.charAt(i) - 'a']--; // decrement for str2
        }

        // Check if all counts are zero
        for (int c : count) {
            if (c != 0)
                return false;
        }

        return true;
    }

    public static List<List<String>> groupAnagram(String[] arr) {
        Map<String, List<String>> l1 = new HashMap<>();
        for (String str : arr) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            l1.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(l1.values());
    }

    public static Character firstNonRepeatingCharacter(String str) {
        Map<Character, Integer> m1 = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            m1.put(ch, m1.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> e1 : m1.entrySet()) {
            if (e1.getValue() == 1) {
                return e1.getKey();
            }
        }
        return '-';
    }

    public static String LongestCommonPrefix(String[] arr) {
        if (arr == null || arr.length == 0)
            return "";

        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            while (!arr[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public static String longestPalindromeString(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);
        s = "#" + s.replaceAll("", "#") + "#";
        int[] dp = new int[s.length()];
        int center = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < right) {
                dp[i] = Math.min(right - i, dp[2 * center - i]);
            }

            while (i - dp[i] - 1 >= 0 && i + dp[i] + 1 < s.length()
                    && s.charAt(i - dp[i] - 1) == s.charAt(i + dp[i] + 1)) {
                dp[i]++;
            }

            if (i + dp[i] > right) {
                center = i;
                right = i + dp[i];
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxStr = s.substring(i - dp[i], i + dp[i] + 1).replaceAll("#", "");
            }
        }

        return maxStr;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcabadfd"));
        System.out.println(validAnagram("avdfd", "vadddf"));
        System.out.println(firstNonRepeatingCharacter("adwweasdc"));
        String[] arr = { "flower", "flow", "flight" };
        System.out.println(LongestCommonPrefix(arr));

        String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = groupAnagram(input);
        System.out.println(result);

        String input1 = "abacdfgdcaba";
        System.out.println("Longest Palindromic Substring: " + longestPalindromeString(input1));
    }
}
