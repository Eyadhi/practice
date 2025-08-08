package List;

// List Interface - ArrayList
import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(3);
        l1.add(4);
        l1.add(19);
        l1.add(2, 5);
        // l1.remove(2);
        // l1.removeFirst();
        Iterator<Integer> it = l1.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println(l1.size());
        boolean b1 = l1.contains(5);
        System.out.println(b1);
        // copy elements from stack to linkedlist
        Stack<String> s1 = new Stack<>();
        LinkedList<String> l2 = new LinkedList<>();
        s1.push("hello");
        s1.push("world");
        l2.addAll(s1);
        Iterator<String> it1 = l2.iterator();
        while (it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }

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
