package cs4120;

public class TestMethods {
	public static void main(String[] args) {
		Boring b = new Boring("hello");
		
		b.nonstaticPrint();
		
		b.staticPrint("goodbye");
	}
}
