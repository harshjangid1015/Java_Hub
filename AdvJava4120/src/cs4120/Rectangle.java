package cs4120;

public class Rectangle implements Comparable
{
	private int length;
	private int width;
	
	Rectangle(int length, int width){
		this.length = length;
		this.width = width;		
	}
	
	public int getArea() {
		return this.length*this.length;
	}
	
	@Override
	public String toString() {
		return "" + this.width + " x " + this.length;
	}
	
	public int compareTo(Object o)
	{
		Rectangle r = (Rectangle)o;
		if(this.length == r.length && this.width == r.width)
		{
			return 0;
		}
		else if (this.getArea() > r.getArea()) 
		{
			return 1;
		}
		else 
		{
			return -1;
		}
	}
	

}

