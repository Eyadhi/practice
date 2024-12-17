package concurrency;

public class Concurrent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        counter c1=new counter();
        c1.increment();
        c1.increment();
         System.out.println(c1.getI());
	}

}
