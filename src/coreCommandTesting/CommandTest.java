package coreCommandTesting;

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