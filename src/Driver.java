
public class Driver 
{
	public static void main(String[] args)
	{
		//String[] inputNames = {"i0", "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8"};
		//Driver.mux(inputNames);
		/*
		Memory m = new Memory(10, 8);
		m.write(5);
		m.setState(2, false, true);
		m.setState(2, true, true);
		m.write(8);
		m.setState(4, false, true);
		m.display();
		m.setState(4, true, false);
		System.out.println(m.read());
		*/
		CompositeMemoryHorizontal cmh = new CompositeMemoryHorizontal(200, 10, 8);
		cmh.write("445345353453453464564566756756756745645643553453453456457567567765670");
		cmh.setState(0, false, true);
		cmh.setState(0, true, false);
		System.out.println(cmh.read());
	}
	
	static String spreadOut(String bin)
	{
		String answer = "";
		for(int i = 0; i < bin.length(); i++)
		{
			answer += bin.charAt(i) + " ";
		}
		return answer.trim();
	}
	
	static void mux(String[] inputNames)
	{
		int numSelectors = Driver.findNumSelectors(inputNames.length);
		int smallest = 0;
		int largest = (int)Math.pow(2, numSelectors) - 1;
		for(int i = smallest; i < inputNames.length; i++)
		{
			String bin = Integer.toBinaryString(i);
			bin = DontSuckHelper.pad(bin, numSelectors);
			bin = Driver.spreadOut(bin);
			System.out.println(bin + " | " + inputNames[i]);
		}
	}
	static int findNumSelectors(int numInputs)
	{
		int i = 1;
		while(Math.pow(2, i) < numInputs)
		{
			i++;
		}
		return i;
	}
}
