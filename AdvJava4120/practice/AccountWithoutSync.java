import java.util.concurrent.*;

public class AccountWithoutSync {
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
//			synchronized (account) {
//				account.deposit(1);
//				}
		}		
	}
	// An inner class for account
	private static class Account{
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
//		public synchronized void deposit(int amount) {	//with synchronized key word no issue of race condition
		public void deposit(int amount) {
//			balance = balance + amount;
			int newBalance = balance + amount;			

			// This delay is deliberately added to magnify the
			// data-corruption problem and make it easy to see.
			try {
				Thread.sleep(5);
			}
			catch(InterruptedException ex){				
			}
			balance = newBalance;
		}
	}
}
