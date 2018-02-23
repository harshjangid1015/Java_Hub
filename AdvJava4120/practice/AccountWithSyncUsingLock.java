
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class AccountWithSyncUsingLock {
	private static Account account = new Account();
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		// Create and launch 100 threads
		for (int i = 0; i < 100; i++) {
			executor.execute(new AddPennyTask());
		}
		executor.shutdown();
		// Wait until all tasks are finished
		while(!executor.isTerminated()) {
		}
		
		System.out.println("what is balance? "+ account.getBalance());
	}
	// A thread for adding a penny to the account
	private static class AddPennyTask implements Runnable{

		@Override
		public void run() {
			account.deposit(1);
		}		
	}
	// An inner class for account
	private static class Account{
		private static Lock lock = new ReentrantLock();	//create a lock
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
		public void deposit(int amount) {
			lock.lock();
		
			try {
				int newBalance = balance + amount;
				// This delay is deliberately added to magnify the
				// data-corruption problem and make it easy to see.
				Thread.sleep(5);
				balance = newBalance;
			}
			catch(InterruptedException ex){				
			}
			finally {
				lock.unlock();//relese the lock
			}
			
		}
	}
}
