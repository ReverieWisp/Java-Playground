package directoryMonitor;

import java.nio.file.Path;

public class DirectoryItem implements Comparable<Object>
{
	public final Path path;
	public final Long lastModified;
	
	public DirectoryItem(Path path, Long lastModified)
	{
		this.path = path;
		this.lastModified = lastModified;
	}
	
	// Override equals operator for .contains
	@Override
	public boolean equals(Object other)
	{
		if(this.compareTo(other) == 0)
			return true;
		
		return false;
	}

	@Override
	// Comparison
	public int compareTo(Object other)
	{
		int strCmp = path.getFileName().toString().compareTo(((DirectoryItem)other).path.getFileName().toString());
		
		if(strCmp == 0)
			return lastModified.compareTo(((DirectoryItem)other).lastModified);
		
		return strCmp;
	}
}
