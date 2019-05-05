package userbench;

public class UserbenchLog
{
	// Logging
	public static void Log(String str) { System.out.println("[Log] [Userbench] " + str); }
	public static void Warn(String str) { System.out.println("[Warn] [Userbench] " + str); }
	public static void Error(String str) { System.err.println("[ERROR] [Userbench] " + str); }
}
