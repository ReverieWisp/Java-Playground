package coreCommandTesting;

import coreCommandTesting.GlobalLog;
import coreCommandTesting.Response;

public class Command
{
	// Handling roles in the base class only
	private String[] whitelist;
	
	public Command()
	{
		this(null);
	}
	
	public Command(String[] whitelist)
	{
		this.whitelist = whitelist;
	}
	
	// Returns if we can run the command. 
	// If no role restrictions are specified, anyone can run it. 
	private boolean CanRun(String userRole)
	{
		if(whitelist == null || whitelist.length == 0)
			return true;
		
		for(int i = 0; i < whitelist.length; ++i)
		{
			if(whitelist[i].equals(userRole))
				return true;
		}
		
		return false;
	}
	
	// Called more internally to verify we can actually call a command and run some logging/tracking
	// before actually running the command itself, if applicable.
	public final void Invoke(String role, String args, Response response)
	{
		if(CanRun(role) == false)
		{
			GlobalLog.Log("Attempted to run command without sufficient permissions: Role " + role);
			return;
		}
		
		OnRun(args, response);
	}
	
	// This is called when the user calling the command is permitted to do so! The response object and the arguments
	// for the command are passed to the function as well. If you don't override this, your command does nothing!
	protected void OnRun(String args, Response res)
	{
		// override me! :D
	}
}