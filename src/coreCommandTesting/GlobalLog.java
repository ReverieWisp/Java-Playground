package coreCommandTesting;

public class GlobalLog
{
	private static void Write(String lead, String body) 
	{ 
		System.out.println("[" + lead + "] " + body); 
	}
	
	public static void Log(String msg) { Write("Log", msg); }
	public static void Warn(String msg) { Write("Warning", msg); }
	public static void Error(String msg) { Write("ERROR", msg); }
}

