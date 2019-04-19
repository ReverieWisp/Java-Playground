package lua;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

// Based on https://github.com/luaj/luaj/blob/master/examples/jse/hyperbolic.java
public class SampleLibrary extends TwoArgFunction
{
	// Required
	public SampleLibrary() {}

	public LuaValue call(LuaValue modname, LuaValue env) {
		LuaValue library = tableOf();
		library.set( "func1", new func1() );
		library.set( "func2", new func2() );
		env.set( "SampleLibrary", library );
		return library;
	}
	
	// Internal static classes that define the library itself. We can set the contents
	// of the table being set as the library inside of the table so that we can access them,
	// just as if we directly required the JavaInLua function.
	static class func1 extends OneArgFunction {
		public LuaValue call(LuaValue x) {
			return LuaValue.valueOf("The first lua function, with argument: " + x.checkstring());
		}
	}
	
	static class func2 extends OneArgFunction {
		public LuaValue call(LuaValue x) {
			return LuaValue.valueOf("Lua function 2! I was passed: " + x.checkstring());
		}
	}
}