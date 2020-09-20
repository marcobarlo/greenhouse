package packagediagramdesktopcomponent.Connection;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PollingThread implements Runnable {
	private static Connection conn;
	private Semaphore sem;
	public PollingThread()
	{
		super();
		conn= Connection.getInstance();
		//conn.connect();
		sem = new Semaphore(0);
	}
	@Override
	public void run()
	{
		while(true)
		{
			List<Integer> lista =conn.getIDS();
			for(int id : lista)
			{
				conn.sendPing(id);
				try {
					sem.tryAcquire(1, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public void pingAck(int id)
	{
		sem.release();
	}
}
