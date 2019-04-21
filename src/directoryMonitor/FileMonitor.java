package directoryMonitor;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileMonitor
{
	private static void Log(String s) { System.out.println("[Log] " + s); }
	private static void Warn(String s) { System.out.println("[Warn] " + s); }
	private static void Error(String s) { System.out.println("[ERROR] " + s); }
	
	private static void LastModified(Path path)
	{
		File file = new File(path.toString());
		
		if(file.exists())
		{
			long milliseconds = file.lastModified();
			DateFormat format = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
			Log("File modified date is: " + format.format(milliseconds));
		}
		else
		{
			Error("File does not exist.");
		}
	}
	
	public static void Monitor(String directory)
	{
		ArrayList<Path> files = new ArrayList<Path>();
		
		try
		{
			try (Stream<Path> paths = Files.walk(Paths.get(directory)))
			{
				paths.filter(Files::isRegularFile).forEach((path)->{ files.add(path); });
			}
		}
		catch(Exception e)
		{
			Error(e.getMessage());
		}
	}
}
