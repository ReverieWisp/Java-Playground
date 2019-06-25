package csv;

import java.util.List;

public class MockConfigSection implements IConfigSection
{
	private final String title;
	List<ConfigItem> pairs;
	
	public MockConfigSection(String title)
	{
		this.title = title;
	}
	
	@Override
	public String getSectionTitle() {
		return title;
	}

	@Override
	public void consume(List<ConfigItem> pairs)
	{
		System.out.println("Consuming " + pairs.size() + " items!");
		this.pairs = pairs;
	}

	@Override
	public List<ConfigItem> produce()
	{
		return pairs;
	}

}
