
public class CheckAgain {
	package cs4120;

import cs4120.ThreadDemo1;
import cs4120.ThreadDemo2;

//*30.11 (Demonstrate deadlock) Write a program that demonstrates deadlock.
	public class DemonstrateDeadlock {
		public static Object Obj1 = new Object();
		public static Object Obj2 = new Object();

		public static void main(String args[]) {
			Thread T1 = new Thread(new ThreadDemo1());
			Thread T2 = new Thread(new ThreadDemo2());

			T1.start();
//			Thread.sleep(5000);
			T2.start();
		}

	}

	class ThreadDemo1 implements Runnable {
		Object Obj2 = null;
		Object Obj1 = null;
		public void run() {
			synchronized (Obj1) {
				System.out.println("Thread 1: Holding lock 1...");

				try { Thread.sleep(10); }
				catch (InterruptedException e) {}
				System.out.println("Thread 1: Waiting for lock 2...");

				synchronized (Obj2) {
					System.out.println("Thread 1: Holding lock 1 & 2...");
				}
			}
		}
	}

	class ThreadDemo2 implements Runnable {
		Object Obj2 = null;
		Object Obj1 = null;
		public void run() {
			
			synchronized (Obj2) {
				System.out.println("Thread 2: Holding lock 2...");

				try { Thread.sleep(10); }
				catch (InterruptedException e) {}
				System.out.println("Thread 2: Waiting for lock 1...");

				synchronized (Obj1) {
					System.out.println("Thread 2: Holding lock 1 & 2...");
				}
			}
		}
	}


}
