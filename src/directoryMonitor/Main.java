package directoryMonitor;

public class Main
{
	private static void Log(String forward, String content) 
	{
		System.out.println("[" + forward + "] "+ content);
	}
	
	private static void Log(String forward, DirectoryItem di) 
	{
		Log(forward, di.path.getFileName().toString());
	}
	
	public static void main(String[] args)
	{
		final int sleepTime = 2000;
		FileMonitor fm = new FileMonitor("./monitor");
		
		while(true)
		{
			Log("Log", "Checking for changes...");
			
			fm.Update(
					  (a)->{ Log("Added", a);   }
					, (u)->{ Log("Updated", u); }
					, (d)->{ Log("Deleted", d); });
			
			try
			{
				Thread.sleep(sleepTime);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
