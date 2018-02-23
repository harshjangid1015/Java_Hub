
public class TaskThreadDemo {
	public static void main(String[] args) {
		//creating a task
		Runnable printA = new PrintChar('a', 100);
		Runnable printB = new PrintChar('b', 100);
		Runnable print100 = new PrintNum(100);
		
		//creating threads
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);
		
		//start a thread
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

//The task for printing a character a specified number of times
class PrintChar implements Runnable{
	private char charToPrint;
	private int times;
	
	public PrintChar(char c, int t) {
		charToPrint = c;
		times = t;
	}
	@Override
	public void run() {
		for (int i = 0; i < times; i++) {
			System.out.print(charToPrint);
		}		
	}	
}

class PrintNum implements Runnable{
	private int lastNum;
	
	public PrintNum(int n) {
		lastNum = n;
	}

	@Override
	public void run() {
		for (int i = 0; i < lastNum; i++) {
			System.out.print(" " + i);
		}
		
	}
}