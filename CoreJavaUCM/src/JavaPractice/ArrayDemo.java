package JavaPractice;

class FailSoftArray2{
	private int a[];
	int size;
	int errval;
	public FailSoftArray2(int size, int errval) {
		this.size = size;
		a = new int[size];
		this.errval = errval;
	}
	int get(int index) {
		if(index >= 0 && index < size)
			return a[index];
		else return errval;
	}
	int set(int index, int val) {
		if(index >= 0 && index < size) {
			a[index] = val;
			return val;
		}
		else return errval;
	}
}

public class ArrayDemo {
	public static void main(String[] args) {
		FailSoftArray2 sample = new FailSoftArray2(5, 9999999);
		int i;
		
		for(i = 0; i < 10; i++) {
			sample.set(i, 10*i+1);
		}
		for(i=0; i<10; i++)
			System.out.println("sample["+i+"]="+sample.get(i));
	}
}
