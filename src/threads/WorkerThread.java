package threads;

/* This is a thread. You can instantiate the object and then call run() on it, and
 * it'll just do its thing.
 * 
 * Alternatively, instead of extends Thread: implements Runnable. You then need to 
 * explicitly start it, provides more control but isn't as managed for you.
 */
public class WorkerThread extends Thread
{
	public int delayMS = 0;  // How long to delay this thread before printing in milliseconds
	public String name = ""; // A name for the thread. This gets printed.
	
	// Constructor
	public WorkerThread(String threadName, int delayMS)
	{
		this.name = threadName;
		this.delayMS = delayMS;
	}
	
	// Method called when spawned as a thread
	@Override
	public void run() 
	{
		workerSleep(delayMS);
		DoWork();
	}
	
	// A uniform DoWork function for benchmarking purposes.
	public void DoWork()
	{
		long msStart = System.currentTimeMillis();
		long num = 0;
		
		for(int i = 0; i < Math.pow(10, 9); ++i)
			num += Math.sqrt(i);
		
		long msEnd = System.currentTimeMillis();
		
		System.out.println("I'm thread " + name + ", I waited for " + delayMS + "ms then I did " + (msEnd - msStart) + "ms of identical work!");
	}
	
	// Handles the try catch requirement java has for sleeping
	private void workerSleep(int ms)
	{
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
