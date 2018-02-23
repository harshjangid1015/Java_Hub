package javaCW;

class FailSoftArray{
	int a[];
	int size;
	int errval;
	void FailSoftArray(int size, int errval) {
		this.size = size;
		a= new int[size];
		this.errval=errval;
	}
	int get(int index) {
		if(index >= 0 && index < size)
			return a[index];
		else return errval;
	}
	int set(int index, int val) {
		if(index >= 0 && index < size) {
			a[index]= val;
		}
		else return errval;
	}

	public class ArrayDemo2 {
		public static void main(String[] args) {
			FailSoftArray sample = new FailSoftArray(5, -1);
			int i;

			for (i=0; i<sample.length; i=i+1)
				sample.set(i, 10*i+1);

			for (i = 0; i<sample.length; i=i+1)
				System.out.println("This is sample(" + i + "): "+ sample[i]);
		}

	}
