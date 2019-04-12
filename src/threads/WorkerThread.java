package threads;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

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
	public WorkerThread()
	{
		
	}
	
	// Method called when spawned as a thread
	@Override
	public void run() 
	{
		DoWork();
	}
	
	
	  /////////////////////////////////////////////////////////////////////////////
	 // These aren't required for threading or anything, just here for testing. //
	/////////////////////////////////////////////////////////////////////////////
	// A uniform DoWork function for benchmarking purposes.
	private static Integer num = 0;
	public void DoWork()
	{
		try 
		{
			String name = null;
			synchronized(num)
			{
				name = "wolfram_" + num;
				++num;
			}
			
			URL	url = new URL("http://api.wolframalpha.com/v1/simple?appid=URH589-HPXQ2XWP5R&i=how+many+centimeters+to+an+inch%3F");
	
			InputStream in = new BufferedInputStream(url.openStream());
			OutputStream out = new BufferedOutputStream(new FileOutputStream(name + ".png"));
			
			for ( int i; (i = in.read()) != -1; ) {
			    out.write(i);
			}
			
			in.close();
			out.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
