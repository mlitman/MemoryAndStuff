
public class Word 
{
	private String bits;
	private int bitWidth;
	
	public Word(int bitWidth)
	{
		this.bitWidth = bitWidth;
		this.bits = "";
		for(int i = 0; i < bitWidth; i++)
		{
			this.bits += "0";
		}
	}
	
	public String getBits() 
	{
		return bits;
	}

	
	public void setBits(String bits) 
	{
		this.bits = bits;
	}

	public void display()
	{
		System.out.println(this.bits + " -> " + Integer.parseInt(this.bits, 2));
	}
}
