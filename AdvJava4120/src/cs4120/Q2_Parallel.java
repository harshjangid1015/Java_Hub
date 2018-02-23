package cs4120;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/*
 * Create a method called sequentialAdd() that counts from 0.0 through 1000000.0 by steps of
0.0001, adding 0.0001 to the total each iteration, and returns the sum. Using the fork and join
framework, create a parallel equivalent called parallelAdd(). In the main method, call
sequentialAdd() and display how long it took for it to run as well as the sum it produced and
then call parallelAdd() and display how long it took for it to run as well as the sum it
produced. (Hint: The sum in both cases should be 1000000.0, possibly with some extraneous
decimal places.)*/

public class Q2_Parallel {
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		System.out.println("Sequential Sum: "+sequentialAdd());
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken for Sequential Sum: "+ (endTime-startTime) + " miliseconds");

		System.out.println();
		startTime = System.currentTimeMillis();
		System.out.println("Parallel Sum: "+parallelAdd());
		endTime = System.currentTimeMillis();
		System.out.println("Time taken for Parallel Sum: "+ (endTime-startTime) + " miliseconds");


	}

	public static double sequentialAdd() {
		double sum =0;
		for(double i=0.0; i<=1000000.0; i+=0.0001 ) {
			sum += 0.0001;
		}
		return sum;
	}

	public static double parallelAdd() {
		RecursiveTask<Double> task = new parSum(0.0001, 0, 1000000);
		ForkJoinPool pool = new ForkJoinPool();
		return pool.invoke(task);

		//		return 0.0;
	}

	private static class parSum extends RecursiveTask<Double>{
		private final int Threshold = 500000;
		private double steps;
		private int start;
		private int end;

		public parSum(double steps, int start, int end) {
			this.steps = steps;
			this.start = start;
			this.end = end;
		}

		@Override
		protected Double compute() {
			if (end - start < Threshold) {
				double sum =0;
				for(int i=start; i<=end; i+=steps) {
					sum += 0.0001;
				}
				return sum;
			}
			else {
				int mid = (start + end)/2;
				RecursiveTask<Double> left = new parSum(steps, start, mid);
				RecursiveTask<Double> right = new parSum(steps, mid, end);
				
				right.fork();
				left.fork();
				return left.join() + right.join();
			}
		}

	}
}
