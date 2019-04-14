package coreCommandTesting;

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
