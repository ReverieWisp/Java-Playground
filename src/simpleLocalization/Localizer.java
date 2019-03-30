package simpleLocalization;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

// A quick-and-dirty localization tool that scrapes the project for calls to itself, then
// generates/updates a file externally (phrases.config) with all the stub values as keys that 
// can then be localized.
public class Localizer
{
	// Util: Reads all lines from a file as a string
	private static String ReadContent(Path filePath)
	{
		StringBuilder contentBuilder = new StringBuilder();
		
		try 
		{
			Stream<String> stream = Files.lines(filePath, StandardCharsets.UTF_8);
			
			stream.forEach(str -> contentBuilder.append(str).append("\n"));
			stream.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return contentBuilder.toString();
	}

	// Recursively acquires all files at and below the specified directory, returning them as an arraylist of paths.
	public static ArrayList<Path> AcquireAllFiles(String startingDir) 
	{
		ArrayList<Path> items = new ArrayList<Path>();
		
		try
		{
			Files.find(Paths.get(startingDir), 999, (path, attributes) -> attributes.isRegularFile()).forEach(items::add);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return items;
	}
	
	// Do processing on each path in the scraped directory here, assuming it's .java
	public static void StripForContents(Path path, ArrayList<String> strings)
	{
		if(path.getFileName().toString().contains(".java"))
		{
			String contents = ReadContent(path);
			String[] split = contents.split("Localizer.Stub");
			
			for(int i = 1; i < split.length; ++i)
			{
				int loc = split[i].indexOf(')');
				
				if(loc != -1)
				{
					try
					{
						String toLocalize = split[i].substring(2, loc - 1);
						
						strings.add(toLocalize);
						System.out.println("[Log] Found stubbed phrase in " + path);
					}
					catch(IndexOutOfBoundsException e)
					{
						System.out.println("[Warn] Found phrase but couldn't parse in file " + path);
					}
				}
			}
		}
	}
	
	// Nothing for now, but in the future will return a parsed and localized version of
	// the string in question if one can be found.
	public static String Stub(String input)
	{
		return input;
	}
	
	// Scrape the project and generate all the possible localizeable phrases
	public static void ScrapeAll()
	{
		ArrayList<String> localizeList = new ArrayList<String>();
		AcquireAllFiles(".\\src").forEach((path) -> StripForContents(path, localizeList));
		
		for(String toStub : localizeList)
			System.out.println(toStub);
	}
}
