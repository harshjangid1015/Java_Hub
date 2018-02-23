package cs4120;

public class Boring {
	private String word;
	
	public void nonstaticPrint()
	{
		System.out.println(this.word);
	}
	
	public static void staticPrint(String s)
	{
		System.out.println(s);
	}
	
	Boring(String word)
	{
		this.word = word;
	}
}
