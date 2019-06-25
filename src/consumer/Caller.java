package consumer;

import java.util.function.Consumer;

// Another arbitrary custom class that manipulates custom data and calls a callback consumer
public class Caller {
	public void Call(Consumer<? super CustomData> callback) {
		callback.accept(new CustomData("bar"));
	}
}

