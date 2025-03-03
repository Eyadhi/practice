package priority_queue;

import java.util.*;

class elem {
	static int x, y;

	public elem(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		elem.x = x;
	}

	public static int getY() {
		return y;
	}

	public static void setY(int y) {
		elem.y = y;
	}
}

class priority_delete {
	public static List<elem> Schedule(List<elem> elems) {
		Collections.sort(elems, Comparator.comparingInt(elem -> priority_queue.elem.getY()));
		Collections.reverse(elems);
		return elems;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<elem> elems = new ArrayList<>();
		elems.add(new elem(2, 4));
		elems.add(new elem(5, 3));
		elems.add(new elem(6, 1));
		elems.add(new elem(7, 4));
		elems.add(new elem(9, 4));
		List<elem> Scheduled = Schedule(elems);
		System.out.println("Schedule");
		for (elem el : Scheduled) {
			System.out.println("x is" + el.x + " y is" + el.getY());
		}
	}
}
