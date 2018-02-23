package javaCW;

public class CircularQueue<T>{
	private T q[];
	private int putloc, getloc;
	public CircularQueue(int size) {	//this int is for size not for type
		q = (T[])new Object[size];
		putloc = 0;
		getloc = 0;
	}
	public void put(T ch) {
		if(isFull()) {
			System.out.println("The queue is full - put() ignored");
			return;
		}
		q[putloc] = ch;
		putloc++;
		if (putloc == q.length) putloc = 0;
	}
	public T get() {
		if(isEmpty()) {
			System.out.println("The queue is empty - get() ignored");
			return null;
		}
		T res = q[getloc];
		getloc ++;
		if(getloc == q.length) getloc = 0;
		return res;
	}
	boolean isEmpty() {
		return getloc == putloc;

	}
	boolean isFull() {
		//		return (getloc == putloc +1) || ((getloc==0) && (putloc == q.length-1));
		return getloc == increment(putloc);		//better than above line
	}
	int increment(int index) {
		index ++;
		if(index == q.length)
			index =0;
		return index;
		// we are wasting one position


	}
}
