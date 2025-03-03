package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bicounter {
	private int i = 0;
	private int j = 0;
	Lock LockI = new ReentrantLock();
	Lock Lockj = new ReentrantLock();

	public void increment() {
		LockI.lock();
		i++;
		LockI.unlock();
	}

	public int getI() {
		return i;
	}

	public void incrementJ() {
		Lockj.lock();
		j++;
		Lockj.unlock();
	}

	public int getJ() {
		return j;
	}
}
