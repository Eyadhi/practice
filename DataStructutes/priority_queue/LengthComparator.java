package priority_queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        // Compare strings based on their lengths
        return Integer.compare(s1.length(), s2.length());
    }

    public static void namereverse() {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Alice");
        names.add("Bob");
        // Sorting names in ascending order using natural ordering
        Collections.sort(names);
        System.out.println("Sorted names (natural order): " + names);

        // Sorting names in descending order using a custom comparator
        Comparator<String> descComparator = Comparator.reverseOrder();
        Collections.sort(names, descComparator);
        System.out.println("Sorted names (descending order): " + names);
    }

    public static void main(String[] args) {
        String[] words = { "apple", "banana", "orange", "strawberry", "kiwi" };

        // Sort the array using the LengthComparator
        Arrays.sort(words, new LengthComparator());

        // Output the sorted array
        for (String word : words) {
            System.out.println(word);
        }
        namereverse();
    }
}
