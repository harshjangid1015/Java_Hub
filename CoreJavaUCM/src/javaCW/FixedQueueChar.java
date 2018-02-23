package javaCW;

public class FixedQueueChar {
	char q[];
	private int putloc, getloc;
	public FixedQueueChar(int size) {
		q = new char[size];
		putloc = 0;
		getloc = 0;
	}
	public void put(char ch) {
		if(isFull()) {
			System.out.println("The queue is full - put() ignored");
			return;
		}
		q[putloc] = ch;
		putloc++;
	}
	public char get() {
		if(isEmpty()) {
			System.out.println("The queue is empty - get() ignored");
			return '\0';
		}
		char res = q[getloc];
		getloc ++;
		return res;
	}
	boolean isEmpty() {
		return getloc == putloc;
		
	}
	boolean isFull() {
		return putloc == q.length;
	}

}
