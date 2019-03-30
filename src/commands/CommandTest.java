package commands;

import core.Command;
import core.Response;

public class CommandTest extends Command
{
	public CommandTest(String[] permitted) 
	{ 
		super(permitted); 
	}
	
	public void OnRun(String args, Response res)
	{
		res.Call("Hello from test!");
	}
}