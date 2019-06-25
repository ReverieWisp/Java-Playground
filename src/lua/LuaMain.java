package lua;

/*
// Lua and java binding via https://github.com/luaj/luaj
import org.luaj.vm2.lib.jse.*;


import org.luaj.vm2.*;
public class LuaMain
{
	public static void main(String[] args)
	{
		// Set up the globals table for calling lua
		Globals globals = JsePlatform.standardGlobals();
	
		// Call java-defined library functions in lua
		String library = 
			  "require('lua.SampleLibrary');\n"
			+ "print('function 1: ', SampleLibrary.func1('Ice Cream'));\n" 
			+ "print('function 2: ', SampleLibrary.func2('Noodles'));\n";
		
		globals.load(library).call();
		
		
		// Call java stand-alone functions in lua 
		String function = "print(require('lua.JavaInLua'));\n";
		
		globals.load(function).call();
		
		
		// Call a lua function in java
		String luaFunction = 
				"function addFunc(first, second)\n" + 
				"	return first + second;\n" + 
				"end\n";
		
		globals.load(luaFunction).call();
		LuaValue addFunc = globals.get("addFunc");
		System.out.println("In java we called lua addFunc, and got: " + addFunc.call(LuaValue.valueOf(3), LuaValue.valueOf(7)));
	}
}

 */