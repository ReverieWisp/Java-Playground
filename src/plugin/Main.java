package plugin;

public class Main
{
	public static void main(String[] args)
	{
		PluginManager pluginManager = new PluginManager("./plugins/");
		pluginManager.CallAll("Test input", (str) -> PluginLog.Log("Plugin called! Got output: " + str));
	}
}
