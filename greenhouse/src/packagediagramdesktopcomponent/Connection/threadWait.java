package packagediagramdesktopcomponent.Connection;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class threadWait extends Thread{
	private int id;
	private Semaphore sem;
	public boolean retval;
	public threadWait(int id)
	{
		super();
		this.id= id;
		this.sem= new Semaphore(0);
	}

	@Override
	public void run() {
		try {
			if(sem.tryAcquire(1, TimeUnit.SECONDS))
				retval=true;
			else
				retval=false;
		} catch (InterruptedException e) {
				retval= false;
		}	
	}
	public int getID()
	{
		return id;
	}
	 
	public void signal()
	{
		sem.release();
	}

}
