package userbench;

import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		UserbenchManager manager = new UserbenchManager();
		List<UserbenchEntry> entries = manager.FindModel("7300");
		
		for(int i = 0; i < entries.size(); ++i)
			UserbenchLog.Log("(" + entries.get(i).type.toString() + ") " + entries.get(i).model);
	}
}
