package stringReplacer;

public class Relpacer
{
	public static String UnEscape(String str)
	{
		str = str.replaceAll("\\\\b", "\b");
		str = str.replaceAll("\\\\n", "\n");
		str = str.replaceAll("\\\\t", "\t");
		str = str.replaceAll("\\\\r", "\r");
		str = str.replaceAll("\\\\f", "\f");
		str = str.replaceAll("\\\\\"", "\"");
		str = str.replaceAll("\\\\\\\\\\\\", "\\\\");
		
		return str;
	}
	
	public static String ReEscape(String str)
	{
		str = str.replaceAll("\\\b", "\\\\\\b");
		str = str.replaceAll("\\\n", "\\\\\\n");
		str = str.replaceAll("\\\t", "\\\\\\t");
		str = str.replaceAll("\\\r", "\\\\\\r");
		str = str.replaceAll("\\\f", "\\\\\\f");
		
		return str;
	}
	
	/*
	public static void main(String[] args)
	{
		String str = "o\\\\k\\testing\\n\\\"something\"\\t else\\ok";
		System.out.println(str);
		System.out.println("-");
		System.out.println(UnEscape(str));
		System.out.println("-");
		System.out.println(ReEscape(UnEscape(str)));
		System.out.println("-");
	}
	*/
}
