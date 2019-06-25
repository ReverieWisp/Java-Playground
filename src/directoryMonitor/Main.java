package directoryMonitor;

/*
import java.nio.file.Path;

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
	
	public static void OnAdded(DirectoryItem a) { Log("Added", a); }
	public static void OnUpdated(DirectoryItem u) { Log("Updated", u); }
	public static void OnDeleted(DirectoryItem d) { Log("Deleted", d); }
	
	
	public static void main(String[] args)
	{
		final int sleepTime = 2000;
		FileMonitor fm = new FileMonitor("./monitor");
		
		while(true)
		{
			fm.Update(Main::OnAdded, Main::OnUpdated, Main::OnDeleted);
			
			try
			{
				Thread.sleep(sleepTime);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			Log("Log", "Updating...");
		}
	}
}
*/
