package determineCallingClass.verylong.packagename;

import java.util.function.Consumer;

import determineCallingClass.IntelligentCallee;

public class Subclass
{
	public void call()
	{
		InternalCall();
	}
	
	private void DoThing(Consumer<? super String> action)
	{
		action.accept("yeet");
	}
	
	private void InternalCall()
	{
		DoThing((str) -> IntelligentCallee.CallMe(str));
	}
}
