package priority_queue;

import java.util.*;

class Elem {
	private int x, y;

	public Elem(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}

class PriorityDelete {
	public static List<Elem> schedule(List<Elem> elems) {
		// Sort in descending order of y (priority)
		elems.sort(Comparator.comparingInt(Elem::getY).reversed());
		return elems;
	}

	public static void main(String[] args) {
		List<Elem> elems = new ArrayList<>();
		elems.add(new Elem(2, 4));
		elems.add(new Elem(5, 3));
		elems.add(new Elem(6, 1));
		elems.add(new Elem(7, 4));
		elems.add(new Elem(9, 4));

		List<Elem> scheduled = schedule(elems);
		System.out.println("Schedule:");
		for (Elem el : scheduled) {
			System.out.println("x is " + el.getX() + ", y is " + el.getY());
		}
	}
}
