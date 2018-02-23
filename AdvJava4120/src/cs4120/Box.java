package cs4120;

public class Box <E> {
	private E contents;
	
	public void fill(E newContents) {
		
	}
	public E look() {
		return this.contents;
	}
	public void empty() {
		this.contents = null;
	}
	
	@Override
	public String toString() {
		return "Box: " + this.contents.toString();
	}
	public static void main(String[] args) {
		Box<Integer> box1 = new Box<>();
		Box<Double> box2 = new Box<>();
		Box<String> box3 = new Box<>();
		
		box1.fill(101);
		box2.fill(3.14);
		box3.fill("Hello");
		
		System.out.println(box1.look());
		System.out.println(box1);
		System.out.println(box2.look());
		System.out.println(box2);
		System.out.println(box3.look());
		System.out.println(box3);
		System.out.println(ToStringCount.toStringCount(box2));
		
	}
}
