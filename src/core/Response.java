package core;

import core.GlobalLog;

public class Response
{
	public void Call(String responseText)
	{
		GlobalLog.Log("We are sending a response! " + responseText);
	}
}
