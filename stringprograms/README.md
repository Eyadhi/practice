1. Reverse Only Letters
## Problem Statement
Given a string `s`, reverse the order of the letters in `s` without affecting the positions of non-letter characters.

### Constraints
- `1 <= s.length <= 100`
- `s` consists of characters with ASCII values in the range `[33, 122]`
- `s` does not contain `"` (double quotes) or `\` (backslash)

## Approach
### Key Observations from Constraints
1. **Length ≤ 100** → We can use a simple O(n) two-pointer approach without worrying about performance bottlenecks.
2. **ASCII range [33, 122]** → All characters are printable, no need for Unicode handling.
3. **No `"` or `\`** → Avoids edge cases involving escape sequences.
4. **Only reverse letters** → Check if a character is a letter using ASCII ranges:
   - Uppercase letters: `'A'` to `'Z'` (ASCII 65–90)
   - Lowercase letters: `'a'` to `'z'` (ASCII 97–122)

## Algorithm
1. Convert the string into a `char[]` so it can be modified (since `String` in Java is immutable).
2. Use two pointers:
   - `left` starts at the beginning
   - `right` starts at the end
3. While `left < right`:
   - If both `arr[left]` and `arr[right]` are letters, swap them and move both pointers inward.
   - If `arr[left]` is not a letter, move `left` forward.
   - If `arr[right]` is not a letter, move `right` backward.
4. Convert the modified `char[]` back into a string and return it.

## Complexity
- **Time Complexity:** O(n) — Each character is visited at most once.
- **Space Complexity:** O(n) — For the `char[]` representation of the string

2. Remove Duplicates
## Problem Statement
Given a string, remove duplicate characters while preserving the order of their first appearance.

### Constraints
1 <= s.length <= 1000
s consists of printable ASCII characters.

## Approach
Use a Set to keep track of characters that have already appeared. Iterate through the string, append characters that are not in the set, and skip duplicates.

## Algorithm
Initialize an empty Set for tracking seen characters.
Create a StringBuilder for the result.
For each character in the string:
If it's not in the set, append it to the result and add it to the set.
Return the result string.

## Complexity
Time Complexity: O(n)
Space Complexity: O(k) where k is the number of unique characters.

3. Check for Valid Anagram
## Problem Statement
Given two strings s and t, determine if t is an anagram of s.

### Constraints
1 <= s.length, t.length <= 5 * 10^4
Both strings contain only lowercase English letters.

## Approach
Count the frequency of each character in both strings and compare.

## Algorithm
If lengths differ, return false.
Use an integer array of size 26 to count characters in s.
Decrease counts while iterating over t.
If any count is non-zero at the end, return false; otherwise true.

## Complexity
Time Complexity: O(n)
Space Complexity: O(1) (since alphabet size is fixed at 26)

4. Group Anagrams
## Problem Statement
Given an array of strings, group the anagrams together.

### Constraints

1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
Strings consist of lowercase English letters.

## Approach
Sort each string’s characters and use the sorted string as a key in a hash map to group anagrams.

## Algorithm
Create a HashMap<String, List<String>>.
For each word:
Sort its characters to form a key.
Append the word to the map entry for that key.
Return the map’s values as the list of anagram groups.

## Complexity
Time Complexity: O(n * k log k) where k = max string length
Space Complexity: O(n * k)

5. First Non-Repeating Character
## Problem Statement
Given a string s, find the first non-repeating character and return its index. If none exists, return -1.

### Constraints

1 <= s.length <= 10^5
s consists of lowercase English letters.

## Approach
Count frequencies of characters, then iterate again to find the first with count 1.

## Algorithm
Use an array of size 26 to store frequencies.
Count all characters in the first pass.
In the second pass, return the index of the first character with count 1.
If none found, return -1.

## Complexity
Time Complexity: O(n)
Space Complexity: O(1)

6. Longest Common Prefix
## Problem Statement
Given a list of strings, find the longest common prefix.

### Constraints

1 <= strs.length <= 200
0 <= strs[i].length <= 200
Strings consist of lowercase English letters.

## Approach
Compare characters position by position across all strings.

## Algorithm
Assume the first string as the prefix.
Compare prefix with each string, shortening it if necessary.
Stop when prefix becomes empty.

## Complexity
Time Complexity: O(n * m) where m = min string length
Space Complexity: O(1)

7. Longest Palindromic Substring (Manacher's Algorithm)
## Problem Statement
Given a string s, return the longest palindromic substring in s.
A palindrome is a string that reads the same backward as forward.

Example
Input: s = "babad"
Output: "bab"  // or "aba"

### Constraints

1 <= s.length <= 1000
s consists of only printable ASCII characters.

## Approach — Manacher's Algorithm
Why Manacher's Algorithm?
Traditional expand-around-center approach takes O(n²) time.
Manacher’s Algorithm solves it in O(n) time by avoiding redundant comparisons.

📜 Algorithm Steps
1. Transform the String
Insert # between characters (and at start/end) to handle even-length palindromes uniformly.
Example: "abba" → ^#a#b#b#a#$ (^ and $ are sentinels to avoid bounds checking).

2. Initialize Arrays
P[i]: radius of palindrome centered at i.
C: current center of the palindrome.
R: right boundary of the palindrome.

3. Iterate through the String
Mirror index: mirror = 2*C - i.
If i < R, set P[i] = min(R - i, P[mirror]).
Expand palindrome around i while characters match.
If palindrome expands beyond R, update C and R.

4. Find Longest Palindrome
The center with the largest P[i] gives the longest palindrome.
Remove # to get the original palindrome.

## Complexity
Time Complexity: O(n)
Space Complexity: O(n)

8. Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true

Explanation:
The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.