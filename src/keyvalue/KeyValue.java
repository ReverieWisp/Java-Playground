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
		public final String KeyValueSplit = "=";
		private HashMap<String, HashMap<String, String>> sectionKeyValue;
		
		// String constructor that parses the input string into the object
		public KeyValueParser(String input)
		{
			sectionKeyValue = new HashMap<String, HashMap<String, String>>();
			
			Parse(input);
		}
		
		// Adds a KeyValue pair to the specified section if it's not already there.
		// Also creates the section if it's not already present.
		public void AddKeyValue(String sectionName, String key, String value)
		{
			AddSection(sectionName);
			sectionKeyValue.get(sectionName).putIfAbsent(key, value);
		}
		
		public HashMap<String, String> GetSection(String sectionName)
		{
			return sectionKeyValue.get(sectionName);
		}
		
		  ///////////////////////
		 // Private functions //
		///////////////////////
		// Adds a given section to the hashmap if it's not already present
		private void AddSection(String sectionName)
		{
			sectionKeyValue.putIfAbsent(sectionName, new HashMap<String, String>());
		}
		
		// Parses out the string passed in into the sectionkeyValue HashMap. 
		private void Parse(String input)
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
				AddSection(sectionName);
					
				// Parse out the pairs within the section, split them all out. 
				String unparsedPairs = section.substring(pos + 1);
				String[] pairs = unparsedPairs.split("\\" + KeyValueLineSeparator);
				
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
					sectionKeyValue.get(sectionName).putIfAbsent(key, value);
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
		
		// Stores the internal hashmap as a string then reutrns it. 
		// Places 1 newline between the sections.
		@SuppressWarnings({"rawtypes", "unchecked"})
		public String ToString()
		{
			String out = "";
			
			Iterator it = sectionKeyValue.entrySet().iterator();
			while (it.hasNext())
			{
				Map.Entry pair = (Map.Entry)it.next();
				out += ("[" + pair.getKey() + "]\n");
				
				Iterator internal = ((HashMap<String, String>)pair.getValue()).entrySet().iterator();
				
				while(internal.hasNext())
				{
					Map.Entry internalPair = (Map.Entry)internal.next();
					out += (internalPair.getKey() + "=" + internalPair.getValue()) + "\n";
				}
				
				out += "\n";
			}
			
			return out;
		}
	}
	
	/*
	public static void main(String[] args)
	{
		String str = "[Example]\n Key 1 = Value 1 \nKey 2 =\nKey 3= Value 3[Number 2]\n    K  \\n ey 3333 =   Yeet\n";
		for(int i = 0; i < 10; ++i)
		{
			KeyValueParser parser = new KeyValueParser(str);
			str = parser.ToString();
			System.out.println(str);
			System.out.println("---");
		}
	}
	*/
}
