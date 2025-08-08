package Map;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        System.out.println(map.get(1)); // One
        map.remove(2);
        System.out.println(map.containsKey(1)); // true
        System.out.println(map.keySet()); // [1]
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
