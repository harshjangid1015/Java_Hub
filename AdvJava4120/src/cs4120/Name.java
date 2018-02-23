package cs4120;

public class Name implements Comparable{
	private String first;
	private String last;
	
	Name (String first, String last)
	{
		this.first = first;
		this.last = last;
	}
	
	public String getFirst() {
		return this.first;
	}
	
	public String getLast() {
		return this.last;
	}
	
	@Override
	public String toString() {
		return this.first + " " + this.last;
	}
	
	public String compareTo(Object o) 
	{
		Name name  = (Name)o;
		
		String n1 = this.toString();
		
		String n2 = name.toString();
		
		return n1.compareTo(n2);
	}

}
