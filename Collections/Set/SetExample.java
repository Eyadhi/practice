package Set;

// Set Interface - HashSet
import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("A"); // Ignored
        System.out.println(set.contains("B")); // true
        set.remove("B");
        System.out.println(set); // [A]
    }
}
