package plugin;

public class Main
{
	public static void main(String[] args)
	{
		PluginManager pluginManager = new PluginManager("./plugins/");
		pluginManager.CallAll("Some string/message to pass to the functions", Main::Output);
	}
	
	public static void Output(String str)
	{
		PluginLog.Log("Plugin called! Got output: " + str);
	}
}
