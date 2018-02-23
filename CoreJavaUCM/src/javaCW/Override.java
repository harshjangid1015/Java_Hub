package javaCW;

class AA {
	private int i, j;
	AA(int a, int b){
		i = a;
		j = b;
	}
	void show() {
		System.out.println("i and j: "+ i + " "+ j);
	}
}

class BB extends AA{
	int k;
	BB(int a, int b, int c){
		super(a, b);
		k = c;
	}
	void show() {
		System.out.println("k: "+k);
	}
}

public class Override {
	public static void main(String[] args) {
		AA obj = new AA(1,2);
		obj.show();
		BB obj2 = new BB(1, 2, 3);
		obj2.show();
		
	}

}
