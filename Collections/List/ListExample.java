package List;

// List Interface - ArrayList
import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add(1, "Three");
        list.set(0, "Zero");
        System.out.println(list.get(1)); // Three
        list.remove(2);
        System.out.println(list.indexOf("Three")); // 1
        List<String> sub = list.subList(0, 1);
        System.out.println(sub); // [Zero]
    }
}
