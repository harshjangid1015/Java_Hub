package cs4120;

public class ManyThreads {
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		Thread[] array = new Thread[1000];
		
		for(int i = 0; i<1000; i++) {
			NumberTask task = new NumberTask(i, (int)(Math.random()*10000000));
//			Thread thread = new Thread(task);
//			thread.start();
			array[i] = new Thread(task);
			array[i].start();
		}
		System.out.println( "Active count :"+Thread.activeCount());
		
		
		while (Thread.activeCount()>1) {
//			System.out.println("---MAIN DONE---");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("running time "+ (endTime - startTime)+ "");
		
		System.out.println("---MAIN DONE---");
		
	}

}
class NumberTask implements Runnable{
	private int id;
	private int number;
	NumberTask(int id, int number){
		this.id = id;
		this.number = number;
	}
	@Override
	public void run() {
		long sum = 0;
		for (int i = 0; i<=number; i++) {
			sum+=number;
		}
		System.out.println("thred " + this.id + " addes up to 0 to "+ this.number+ ": " + sum);
	}
}