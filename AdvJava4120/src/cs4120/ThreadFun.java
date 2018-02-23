package cs4120;

public class ThreadFun {
	public static void main(String[] args)throws Exception {
		
//		Task task1 = new Task("Hello", 1000);
		Task task1 = new Task("A", 1000);
//		Task task2 = new Task("GoodBye", 1000);
		Task task2 = new Task("B", 1000);
//		Task task3 = new Task("triskedaphobic", 1000);
		Task task3 = new Task("B", 1000);
		Task task4 = new Task("D", 1000);
		Task task5 = new Task("E", 1000);
		Task task6 = new Task("F", 1000);
		Task task7 = new Task("G", 1000);
		Task task8 = new Task("H", 1000);
		
		Thread thred1 = new Thread(task1);
		Thread thred2 = new Thread(task2);
		Thread thred3 = new Thread(task3);
		Thread thred4 = new Thread(task4);
		Thread thred5 = new Thread(task5);
		Thread thred6 = new Thread(task6);
		Thread thred7 = new Thread(task7);
		Thread thred8 = new Thread(task8);

		
		thred1.setPriority(Thread.MIN_PRIORITY);
		thred2.setPriority(Thread.MAX_PRIORITY);
		thred3.setPriority(Thread.MAX_PRIORITY);
		thred4.setPriority(Thread.MAX_PRIORITY);
		thred5.setPriority(Thread.MAX_PRIORITY);
		thred6.setPriority(Thread.MAX_PRIORITY);
		thred7.setPriority(Thread.MAX_PRIORITY);
		thred8.setPriority(Thread.MAX_PRIORITY);

		
		System.out.println("thred1: " + thred1.getPriority());
		System.out.println("thred2: " + thred2.getPriority());
		System.out.println("thred3: " + thred3.getPriority());
		System.out.println("thred4: " + thred4.getPriority());
		System.out.println("thred5: " + thred5.getPriority());
		System.out.println("thred6: " + thred6.getPriority());
		System.out.println("thred7: " + thred7.getPriority());
		System.out.println("thred8: " + thred8.getPriority());
		
		thred1.start();
//		thred1.join();
		thred2.start();
//		thred2.join();
		thred3.start();
//		thred3.join();
		
//		thred1.join();
//		thred2.join();
//		thred3.join();
		thred4.start();
		thred5.start();
		thred6.start();
		thred7.start();
		thred8.start();
		
		System.out.println("main() Done");
	}
}
 class Task implements Runnable{
	 private String word;
	 private int number;
	 
	 Task(String word, int number){
		 this.word = word;
		 this.number = number;
		 
	 }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i<this.number; i++) {
			System.out.print(this.word);
			
			if(this.word.equals("A")) {
				try {
//					Thread.yield();
					Thread.sleep(100);
				}
				catch(Exception ex) {
					
				}
			}
		}
		System.out.println("---Done---");
	}
	 
	
 }