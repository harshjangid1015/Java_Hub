package cs4120;

import java.util.concurrent.*;


/*30.15 (Parallel sum) Implement the following method using Fork/Join to find the sum of a list.
public static double parallelSum(double[] list)
Write a test program that finds the sum in a list of 9,000,000 double values. */
public class ParallelSum {
	public static void main(String[] args) {
		//creating a list
		double[] list = new double[9000000];
		for(int i=0; i<list.length; i++) {
			list[i] = Math.random();
		}
		long startTime = System.currentTimeMillis();
		System.out.println("Parallel Sum: " + parallelSum(list));
		long endTime = System.currentTimeMillis();
		System.out.println("Parallel time with " + Runtime.getRuntime().availableProcessors() +" processors is " + (endTime - startTime) + " milliseconds");
		
		
		System.out.println();
		startTime = System.currentTimeMillis();
		System.out.println("Sequential Sum: " + sequentialSum(list));
		endTime = System.currentTimeMillis();		
		System.out.println("Time taken: " + (endTime-startTime)+ " miliseconds");
		
	}
	
	public static double parallelSum(double[] list) {
		RecursiveTask<Double> task = new parSum(list, 0, list.length);
		ForkJoinPool pool = new ForkJoinPool();
		return pool.invoke(task);
	}
	public static double sequentialSum(double[] list) {
		double sum = 0;
		for (int i = 0; i < list.length; i++) {
			sum += list[i];
		}
		return sum;
		
	}
	
	private static class parSum extends RecursiveTask<Double>{
		private final int Threshold = 500;
		private double[] list;
		private int low;
		private int high;
		
		public parSum(double[] list, int low, int high) {
			this.list = list;
			this.low = low;
			this.high = high;
		}

		@Override
		protected Double compute() {
//			Double sum = 0.0;
			if(high - low < Threshold) {
				Double sum = 0.0;
				for(int i=low; i<high; i++) {
					sum += list[i];
				}
				return sum;
			}
			else {
				int mid = (low + high)/2;
				RecursiveTask<Double> left = new parSum(list, low, mid);
				RecursiveTask<Double> right = new parSum(list, mid, high);
				
				right.fork();
				left.fork();
				return left.join() + right.join();
			}
			
			
			
		}
		
	}
}
