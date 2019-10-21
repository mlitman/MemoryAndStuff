
public class DontSuckHelper 
{
	public static String pad(String bin, int bits)
	{
		int extraZeros = bits - bin.length();
		for(int i = 0; i < extraZeros; i++)
		{
			bin = "0" + bin;
		}
		return bin;
	}
}
