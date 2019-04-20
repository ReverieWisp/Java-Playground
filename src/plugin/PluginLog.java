package plugin;

public class PluginLog
{
	public static void Log(String s) { System.out.println("[Log] " + s); }
	public static void Warn(String s) { System.out.println("[Warn] " + s); }
	public static void Error(String s) { System.out.println("[ERROR] " + s); }
}
