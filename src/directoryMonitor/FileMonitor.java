package directoryMonitor;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FileMonitor
{
	private void Log(String s) { System.out.println("[Log] " + s); }
	private void Warn(String s) { System.out.println("[Warn] " + s); }
	private void Error(String s) { System.out.println("[ERROR] " + s); }
	
	private String directory; 
	private ArrayList<DirectoryItem> last;
	
	// Constructs a new file monitor and logs initialization
	public FileMonitor(String directory)
	{
		Log("Reading initial file set in: " + directory.toString());
		
		this.directory = directory;
		this.last = Scrape();
		
		Print(last);
	}
	
	// Check when a file was last modified by path
	private Long LastModified(Path path)
	{
		File file = new File(path.toString());
		
		if(file.exists())
		{
			return file.lastModified();
		}
		else
		{
			Error("File does not exist.");
			return null;
		}
	}
	
	// Scrape the target directory for all files and store them as custom objects in the list
	private ArrayList<DirectoryItem> Scrape()
	{
		ArrayList<DirectoryItem> files = new ArrayList<DirectoryItem>();
		
		try
		{
			try (Stream<Path> paths = Files.walk(Paths.get(directory)))
			{
				paths.filter(Files::isRegularFile).forEach((path)->
				{ 
					files.add(new DirectoryItem(path, LastModified(path)));
				});
			}
		}
		catch(Exception e)
		{
			Error(e.getMessage());
		}
		
		return files;
	}
	
	// Update function - the first callback is called if a new item is added to the directory,
	// second is called if an item is updated, and third is called if an item is removed.
	@SuppressWarnings("unchecked")
	public void Update(Consumer<? super DirectoryItem> onAdd, Consumer<? super DirectoryItem> onUpdate, Consumer<? super DirectoryItem> onDelete)
	{
		// Unparsed
		ArrayList<DirectoryItem> active = Scrape();
		ArrayList<DirectoryItem> curr = (ArrayList<DirectoryItem>)active.clone(); 
		ArrayList<DirectoryItem> prev = (ArrayList<DirectoryItem>)last.clone();
		
		// Parsed
		ArrayList<DirectoryItem> added = new ArrayList<DirectoryItem>();
		ArrayList<DirectoryItem> updated = new ArrayList<DirectoryItem>();
		ArrayList<DirectoryItem> deleted = new ArrayList<DirectoryItem>();
		ArrayList<DirectoryItem> existing = new ArrayList<DirectoryItem>();
		
		// Iterate over everything
		for(int i = 0; i < active.size(); ++i)
		{
			// If we contain the previous, remove it.
			if(prev.contains(active.get(i)))
			{
				DirectoryItem item = active.get(i);
				
				prev.remove(item);
				curr.remove(item);
				existing.add(item);
			}
			
			// Check all other cases
			for(int j = 0; j < prev.size(); ++j)
			{
				DirectoryItem l1 = active.get(i);
				DirectoryItem l2 = prev.get(j);
						
				// Check if item is updated.
				if(l1.path.toString().equals(l2.path.toString()))
				{
					updated.add(l1);
					prev.remove(l2);
					curr.remove(l1);
					onUpdate.accept(l2);
				}
			}
		}
	
		// Anything that wasn't removed from prev has been removed.
		for(int j = 0; j < prev.size(); ++j)
		{
			DirectoryItem item = prev.get(j);
			
			deleted.add(item);
			onDelete.accept(item);
		}
		
		prev.clear();
		
		// Add all the remaining things in the current directory as added items.
		for(int i = 0; i < curr.size(); ++i)
		{
			DirectoryItem item = curr.get(i);
			
			added.add(item);
			onAdd.accept(item);
		}
		
		// Rebuild local state
		last.clear();
		last.addAll(existing);
		last.addAll(added);
		last.addAll(updated);
		Collections.sort(last);
		
		if(last.size() == 0)
			Warn("There's nothing at all in a FileMonitor's target folder!");
	}
	
	// Prints out an arraylist of items from a directory by path
	private void Print(ArrayList<DirectoryItem> toPrint)
	{
		for(int i = 0; i < toPrint.size(); ++i)
			Log(toPrint.get(i).path.toString());
	}
}
