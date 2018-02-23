package cs4120;
import java.util.concurrent.*;
public class ManyThreadsPool {
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		ExecutorService thredpool = Executors.newFixedThreadPool(5);
		for(int i = 0;  i<1000; i++) {
			NumberTask task = new NumberTask(i, (int)(Math.random()*10000000));
			thredpool.execute(task);
		}
		thredpool.shutdown();
//		thredpool.shutdownNow();
//		System.out.println(thredpool.isShutdown());
//		System.out.println(thredpool.isTerminated());
		
		while (thredpool.isTerminated()) {
			System.out.println("---MAIN DONE---");
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
