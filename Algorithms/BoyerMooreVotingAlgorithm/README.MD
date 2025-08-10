### Boyer–Moore Voting Algorithm
The classic version finds the element that appears more than n/2 times (majority element).
The extended version can find all elements that appear more than n/3 times (there can be at most two such elements) or even more general thresholds.

### Boyer–Moore Majority Vote Algorithm (n/2 case)
Logic:
Maintain a candidate and count.
Scan the array once to find the candidate.
Scan again to verify.

Time: O(n)
Space: O(1)

### Extended Version (n/3 case)
If the problem is:
Find all elements that appear more than ⌊n/3⌋ times.
We can maintain two candidates and two counters because:
By the pigeonhole principle, there can be at most 2 elements that appear more than n/3 times.


### Generalized Boyer–Moore Voting Algorithm
Goal:
Find all elements that appear more than ⌊n/k⌋ times in an array.

Key idea:
At most k - 1 elements can appear more than ⌊n/k⌋ times.
Keep a map of candidates and their counts, size ≤ k - 1.
For each element:
If it’s already in candidates → increment count.
Else if candidates < k - 1 → add it with count 1.
Else → decrement all counts; remove any that reach 0.
Finally, verify counts in a second pass.