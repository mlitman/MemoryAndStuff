import java.math.BigInteger;

public class CompositeMemoryHorizontal 
{
	private Memory[] theMemory;
	private int bitWidth;
	private boolean wen, ren;
	private int address;
	private String writeData;
	
	public CompositeMemoryHorizontal(int numMemChips, int numWords, int bitWidth)
	{
		this.bitWidth = numMemChips * bitWidth;
		this.theMemory = new Memory[numMemChips];
		for(int i = 0; i < this.theMemory.length; i++)
		{
			this.theMemory[i] = new Memory(numWords, bitWidth);
		}
	}
	
	public void setState(int address, boolean ren, boolean wen)
	{
		this.address = address;
		this.ren = ren;
		this.wen = wen;
		
		for(Memory m : this.theMemory)
		{
			m.setState(address, ren, wen);
		}
	}
	
	public void write(String wordDecimalData)
	{
		BigInteger bi = new BigInteger(wordDecimalData);
		this.writeData = bi.toString(2);
		this.writeData = DontSuckHelper.pad(this.writeData, this.bitWidth);
		int currPos = this.writeData.length();
		String nextBits;
		for(Memory m : this.theMemory)
		{
			nextBits = this.writeData.substring(currPos - m.getBitWidth(), currPos);
			currPos -= m.getBitWidth();
			m.write(Integer.parseInt(nextBits, 2));
		}
	}
	
	public int read()
	{
		if(this.ren)
		{
			//reassemble bits for the read
			String theBits = "";
			int val;
			for(Memory m : this.theMemory)
			{
				val = m.read();
				theBits =  DontSuckHelper.pad(Integer.toBinaryString(val), 
						m.getBitWidth()) + theBits;
			}
			return Integer.parseInt(theBits, 2);
		}
		throw new RuntimeException("Memory Fault - ren not set!!!");
	}
	
	public void display()
	{
		for(Memory m : this.theMemory)
		{
			m.display();
			System.out.println("*****");
		}
	}
}
