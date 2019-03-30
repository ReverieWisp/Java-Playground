package commands;

import core.Command;
import core.Response;

public class CommandPing extends Command 
{
	public CommandPing(String[] whitelist) 
	{ 
		super(whitelist); 
	}
	
	public void OnRun(String args, Response res)
	{
		res.Call("Pong!");
	}
}
