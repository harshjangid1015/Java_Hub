package cs4120;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/*30.16 (Parallel matrix addition) Programming Exercise 8.5 describes how to perform matrix addition. Suppose you have multiple 
processors, so you can speed up the matrix addition. Implement the following method in parallel.
public static double[][] parallelAddMatrix(double[][] a, double[][] b)
Write a test program that measures the execution time for adding two 2,000 * 2,000 matrices using the parallel method and 
sequential method, respectively.*/

public class ParallelMatrixAddition {
	public static void main(String[] args) {
		int size = 2000;
		double[][] a = new double[size][size];
		double[][] b = new double[size][size];

		for (int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				a[i][j] = Math.random();
				b[i][j] = Math.random();
			}
		}

		long startTime = System.currentTimeMillis();
		parallelMatrixAddition(a, b);
		long endTime = System.currentTimeMillis();
		System.out.println("Time take in Prallel Matrix Addition with  " + Runtime.getRuntime().availableProcessors() +" processors is "+(endTime- startTime) + " miliseconds");
				
		System.out.println();
		startTime = System.currentTimeMillis();
		addMatrixSeq(a, b);
		endTime = System.currentTimeMillis();
		System.out.println("Time take in sequential Matrix Addition: " +(endTime- startTime) + " miliseconds");
	}

	public static double[][] parallelMatrixAddition(double[][] a, double[][] b) {
		double[][] c = new double[a.length][a.length];

		RecursiveAction mainTask = new addMatrixPar(a, b, c, 0, a.length, 0, a.length);
		ForkJoinPool pool = new ForkJoinPool(4);
		pool.invoke(mainTask);
		double sum = 0;
		for (int i=0; i<c.length; i++) {
			for(int j=0; j<c[0].length; j++) {
				sum+= c[i][j];
				
			}
		}
		System.out.println("Sum of all elements of resulting matrix: " + sum);
		return c;
	}

	private static class addMatrixPar extends RecursiveAction{
		private int Threshold = 100;
		private double[][] a;
		private double[][] b;
		private double[][] c;
		private int x1;
		private int x2;
		private int y1;  
		private int y2;

		public addMatrixPar(double[][] a, double[][] b, double[][] c, int x1, int x2, int y1, int y2) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;   
			this.y2 = y2;
		}

		@Override
		protected void compute() {
			if(((x2-x1) < Threshold) || ((y2-y1) < Threshold)) {
				for(int i = x1; i<x2; i++) {
					for(int j = y1; j<y2; j++) {
						c[i][j] = a[i][j] + b[i][j];
					}
				}
			}
			else {
				int midX = (x1 + x2)/2;
				int midY = (y1 + y2)/2;
				
				invokeAll(
						new addMatrixPar(a, b, c, x1, midX, y1, midY),
						new addMatrixPar(a, b, c, midX, x2, y1, midY),
						new addMatrixPar(a, b, c, x1, midX, midY, y2),
						new addMatrixPar(a, b, c, midX, x2, midY,y2)
						);
			}
		}
	}
	
	public static double[][] addMatrixSeq(double[][] a, double[][] b){
		double[][] c = new double[a.length][a[0].length];
		for(int i = 0; i<a.length; i++) {
			for(int j = 0; j<a[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j]; 
			}
		}
		double sum = 0;
		for (int i=0; i<c.length; i++) {
			for(int j=0; j<c[0].length; j++) {
				sum+= c[i][j];
				
			}
		}
		System.out.println("Sum of all elements of resulting matrix: " + sum);
		return c;
	}
}
