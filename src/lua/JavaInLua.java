package lua;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.ZeroArgFunction;

// LibFunction section of http://www.luaj.org/luaj/3.0/README.html
public class JavaInLua extends ZeroArgFunction {
	public LuaValue call() {
		return valueOf("I'm being called in lua but was implemented in java!");
	}
}