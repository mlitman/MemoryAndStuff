
public class Memory 
{
	private Word[] theWords;
	private boolean wen, ren;
	private int address;
	private String writeData;
	private int bitWidth;
	
	
	public Memory(int numWords, int bitWidth)
	{
		this.reset();
		this.bitWidth = bitWidth;
		this.theWords = new Word[numWords];
		for(int i = 0; i < this.theWords.length; i++)
		{
			this.theWords[i] = new Word(bitWidth);
		}
	}
	
	private void reset()
	{
		this.wen = false;
		this.ren = false;
		this.address = -1;
		this.writeData = "";
	}
	
	public void write(int wordDecimalData)
	{
		this.writeData = Integer.toBinaryString(wordDecimalData);
		this.writeData = DontSuckHelper.pad(this.writeData, this.bitWidth);
	}
	
	public int read()
	{
		if(this.ren)
		{
			return Integer.parseInt(this.theWords[this.address].getBits(),2);
		}
		throw new RuntimeException("Memory Fault - ren not set!!!");
	}
	
	public void setState(int address, boolean ren, boolean wen)
	{
		this.address = address;
		this.ren = ren;
		this.wen = wen;
		
		//can we write?
		if(this.wen && !this.ren)
		{
			this.theWords[this.address].setBits(this.writeData);
		}
	}
	
	
	public int getBitWidth() {
		return bitWidth;
	}

	public void display()
	{
		for(Word w : this.theWords)
		{
			w.display();
		}
	}
}
