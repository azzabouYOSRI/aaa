package TPPROBSOLV;

import java.util.Timer;
import java.util.TimerTask;

public class Minuteur extends TimerTask{
	private Thread thread;
	private Timer timer;
	
	public Minuteur(Thread thread, Timer timer)
	{
		this.thread = thread;
		this.timer = timer;
	}
	
	public void run()
	{
		if(thread != null && thread .isAlive())
		{
			thread.interrupt();
			timer.cancel();
			System.out.println("wfe");
		}
	}
}
