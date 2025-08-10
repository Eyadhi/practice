package stringprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringProgram {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (isLetter(arr[left]) && isLetter(arr[right])) {
                // swap letters
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else if (!isLetter(arr[left])) {
                left++;
            } else {
                right--;
            }
        }
        return new String(arr);
    }

    // ASCII check for uppercase or lowercase English letters
    private boolean isLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new LinkedHashSet<>();

        for (char ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static Boolean validAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

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

    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> grouped = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            grouped.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(grouped.values());
    }

    public static Character firstNonRepeatingCharacter(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '-';
    }

    public static String longestCommonPrefix(String[] words) {
        if (words == null || words.length == 0)
            return "";

        String prefix = words[0];
        for (int i = 1; i < words.length; i++) {
            while (!words[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public static String longestPalindromeSubstring(String s) {
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

    public static String result(String[] arr, String str) {
        String res = "";
        int len = str.length();
        int minMismatch = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            String current = arr[i];
            if (current.length() < len) {
                continue;
            }
            int mismatch = 0;
            for (int j = 0; j < len; j++) {
                if (str.charAt(j) != current.charAt(j)) {
                    mismatch++;
                    if (mismatch >= minMismatch)
                        break;
                }
            }
            if (mismatch < minMismatch) {
                minMismatch = mismatch;
                res = current;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcabadfd"));

        System.out.println(validAnagram("avdfd", "vadddf"));

        System.out.println(firstNonRepeatingCharacter("adwweasdc"));

        String[] arr = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(arr));

        String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = groupAnagrams(input);
        System.out.println(result);

        String input1 = "abacdfgdcaba";
        System.out.println("Longest Palindromic Substring: " + longestPalindromeSubstring(input1));

        String[] arr1 = { "bandbk", "bakaba", "aanaba", "apple" };
        String target = "banana";
        System.out.println(result(arr1, target));
    }
}
