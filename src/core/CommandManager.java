package core;

import java.util.HashMap;

import core.GlobalLog;
import core.Response;

public class CommandManager 
{
	private HashMap<String, Command> commands;
	
	public CommandManager()
	{
		commands = new HashMap<String, Command>();
	}
	
	public void Register(String invokeName, Command command)
	{
		Command previousContent = commands.put(invokeName, command);
		
		if(previousContent == null)
			GlobalLog.Log("Registered command " + invokeName + " successfully!");
		else
			GlobalLog.Warn("Registered command " + invokeName + " but it wrote over another command!");
	}
	
	// Pretend that user is an object and that command is an object
	public void Invoke(String user, String command, String args, Response context)
	{
		Command com = commands.get(command);
		if(com == null)
		{
			GlobalLog.Warn("Tried to invoke a command that doesn't exist: " + command);
			return;
		}
		
		com.Invoke(user, args, context);
	}
}
