package consumer;

// A third class that uses both of the others 
public class DataWrangler {
	public void DoThings() {
		Caller caller = new Caller();

		caller.Call((this)::DoThingMember);
		caller.Call(DataWrangler::DoThingStatic);
		caller.Call((data) -> { /* ... */ }); 
	}
	
	public void DoThingMember(CustomData data) {
		//...
	}
	
	public static void DoThingStatic(CustomData data) {
		//...
	}
}
