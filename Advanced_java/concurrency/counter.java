package concurrency;

public class counter {
	int i=0;
	synchronized public void increment(){
		i++;
	}
	public  int getI() {
		return i++;
	}

}
