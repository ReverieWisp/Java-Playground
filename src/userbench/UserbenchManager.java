package userbench;

import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

// All things considered, this doesn't need to be particularly efficient since anything
// less than 10ms of search time won't be noticable to an end user really, not for
// a networked application that's not performance bound. 
public class UserbenchManager
{
	// Variables
	public final String directory = "assets/userbench/";
	public final String extension = ".csv";
	public final String lineDelimiter = "\n";
	private List<UserbenchEntry> raw;
	
	// Read in all extensions
	public UserbenchManager()
	{
		long start = Instant.now().toEpochMilli();
		
		raw = new ArrayList<UserbenchEntry>();
		
		File d = new File(directory);
		File[] files = d.listFiles((f, name) -> name.endsWith(extension));
		
		if(files != null)
		{
			for(File f : files)
			{
				String contents = FileUtils.ReadContent(f);
				String[] lines = contents.split(lineDelimiter);
				
				for(int i = 1; i < lines.length; ++i)
					raw.add(new UserbenchEntry(lines[i]));
			}
		}
		else
		{
			UserbenchLog.Warn("No " + extension + " files where found in " + directory);
		}
		
		UserbenchLog.Log("Took " + (Instant.now().toEpochMilli() - start) + " ms to load " + raw.size() + " entries from " + files.length + " " + extension + " file" + (raw.size() > 1 ? "s" : ""));
	}
	
	
	// Search for a substring in the model name
	public List<UserbenchEntry> FindModel(String modelSubstr)
	{
		long start = Instant.now().toEpochMilli();
		List<UserbenchEntry> matching = new ArrayList<UserbenchEntry>();
		String searchSubstr = modelSubstr.toLowerCase();
		
		for(UserbenchEntry e : raw)
		{
			String model = e.model.toLowerCase().trim();
			
			if(model.contains(searchSubstr))
				matching.add(e);
		}
		
		UserbenchLog.Log("Searched for '" + searchSubstr + "' for "+ (Instant.now().toEpochMilli() - start) + "ms and found " + matching.size() + " entries.");
		return matching;
	}
}
