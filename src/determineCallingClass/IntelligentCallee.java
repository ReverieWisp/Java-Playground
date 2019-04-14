package determineCallingClass;

public class IntelligentCallee
{
	public static void Log(Object toLog) { System.out.println("[Log] " + toLog); }
	
	private static String ExtractCaller(StackTraceElement[] stack)
	{
		if(stack.length < 2)
			return null;
		
		// Resolves to: determineCallingClass.verylong.packagename.Subclass.InternalCall(Subclass.java:14)
		String caller = stack[2].toString();
		
		// Resolves to: determineCallingClass.verylong.packagename.Subclass.InternalCall
		caller = caller.substring(0, caller.indexOf('('));
		
		// Resolves to: determineCallingClass.verylong.packagename.Subclass
		caller = caller.substring(0, caller.lastIndexOf('.')); 
		
		// Resolves to: Subclass
		caller = caller.substring(caller.lastIndexOf('.') + 1);
		
		// Return
		return caller;
	}
	
	public static void CallMe(String arg)
	{
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		
		Log("Stack is:");
		
		for(int i = 0; i < stack.length; ++i)
			Log("  " + stack[i]);
		
		String callingClass = ExtractCaller(stack);
		
		Log("Parsed:");
		Log("  The class " + callingClass + " called this function with the following: "+ arg);
	}
}
