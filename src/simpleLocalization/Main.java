package simpleLocalization;

public class Main
{
	public static void main(String[] args)
	{
		// Read in localization config, scrape for locations internally.
		Localizer.UpdateLocFromDisk();
		Localizer.ScrapeAll();
		Localizer.SaveLocToDisk();
		
		System.out.println("-----");
		
		System.out.println(Localizer.Stub("Phrase 1"));
		System.out.println(Localizer.Stub("Phrase 2"));
		System.out.println(Localizer.Stub("Phrase 3"));
	}
}
