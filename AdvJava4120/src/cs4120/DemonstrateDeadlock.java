package cs4120;

import java.util.concurrent.locks.*;

//*30.11 (Demonstrate deadlock) Write a program that demonstrates deadlock.
public class DemonstrateDeadlock {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {			
			@Override
			public void run() {
				darkRoom.giveFlashLightAndBatteries();				
			}
		});
		Thread thread2 = new Thread(new Runnable() {			
			@Override
			public void run() {
				darkRoom.giveBatteriesAndFlashLight();
			}
		});
		thread1.start();
		thread2.start();
	}
	
}

class darkRoom{
	private static Lock FlashLight = new ReentrantLock();
	private static Lock Batteries = new ReentrantLock();
	
	public static void giveFlashLightAndBatteries() {
		
		try {
			FlashLight.lock();
			Batteries.lock();
			System.out.println("Lights on from thread1");
		}
		finally {
			Batteries.unlock();
			FlashLight.unlock();			
		}
				
	}
	
	public static void giveBatteriesAndFlashLight() {
		try {
			Batteries.lock();
			FlashLight.lock();
			/*use this if you don't want deadlock
			 * FlashLight.lock();
			   Batteries.lock();*/
			
			System.out.println("Lights on from thread2");
		}
		finally {
			FlashLight.unlock();
			Batteries.unlock();
		}
	}
}


