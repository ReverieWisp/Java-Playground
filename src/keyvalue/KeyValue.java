package keyvalue;

import java.util.*;

public class KeyValue 
{
	public static class KeyValueParser
	{
		// Variables
		public final char SectionStart = '[';
		public final char SectionEnd = ']';
		public final char KeyValueLineSeparator = '\n';
		public final String KeyValueSplit = " =";
		private HashMap<String, HashMap<String, String>> sectionKeyValue;
		
		// String constructor that parses the input string into the object
		public KeyValueParser(String input)
		{
			sectionKeyValue = new HashMap<String, HashMap<String, String>>();
			
			Parse(input);
		}
		
		// Parses out the string passed in into the sectionkeyValue HashMap. 
		public void Parse(String input)
		{
			String[] sections = input.split("\\" + SectionStart);

			for(int sec = 0; sec < sections.length; ++sec)
			{
				// Gather information about the contents of the section, and the header.
				String section = sections[sec];
				if(section.length() < 2)
					continue;
				
				int pos = section.indexOf(SectionEnd);
				if(pos == -1)
					continue;
				
				// Parse section name. If it already exists, don't bother making it.
				String sectionName = section.substring(0, pos);
				sectionKeyValue.putIfAbsent(sectionName, new HashMap<String, String>());
					
				// Parse out the pairs within the section, split them all out. 
				String unparsedPairs = section.substring(pos + 1);
				String[] pairs = unparsedPairs.split("" + KeyValueLineSeparator);
				
				// Parse out valid key-value pairs, and store them in the specified section.
				// At this point, we can be guarenteed that sectionName is in the Hashmap.
				for(int pair = 0; pair < pairs.length; ++pair)
				{
					String line = pairs[pair];
					int splitPos = line.indexOf(KeyValueSplit);
					if(splitPos < 0)
						continue;
					
					String key = line.substring(0, splitPos);
					String value = line.substring(splitPos + KeyValueSplit.length());
					sectionKeyValue.get(sectionName).put(key, value);
				}
			}
		}
		
		// Dumps out a string array
		@SuppressWarnings("unused")
		private void Dump(String[] toPrint)
		{
			System.out.println("Length: " + toPrint.length);
			for(int i = 0; i < toPrint.length; ++i)
				System.out.println(toPrint[i]);
		}
		
		// Prints out the hashmap type
		@SuppressWarnings({"rawtypes", "unused"})
		private void Dump(HashMap<String, HashMap<String, String>> toPrint)
		{
			Iterator it = toPrint.entrySet().iterator();
			while (it.hasNext())
			{
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println("|" + pair.getKey() + "|" + pair.getValue() + "|");
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		String str = "[Example]\n Key 1 = Value 1 \nKey 2 =\nKey 3 = Value 3";
		new KeyValueParser(str);
	}
}
