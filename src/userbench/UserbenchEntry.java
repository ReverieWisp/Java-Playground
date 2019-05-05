package userbench;

public class UserbenchEntry
{
	public final UserbenchType type;
	public final String partNumber;
	public final String brand;
	public final String model;
	public final int rank;
	public final float benchmark;
	public final int samples;
	public final String url;
	
	UserbenchEntry(String input)
	{
		String[] row = input.split(",");
		
		type = UserbenchType.valueOf(row[0]);
		partNumber = row[1];
		brand = row[2];
		model = row[3];
		rank = Integer.parseInt(row[4]);
		benchmark = Float.parseFloat(row[5]);
		samples = Integer.parseInt(row[6]);
		url = row[7];
	}
}
