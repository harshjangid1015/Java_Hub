package javaCW;

public class TwoD {
	public static void main(String[] args) {
		int i, j;
		int table[][] = new int [3][4];
		
		for(i = 0; i < 3; i++) {
			for(j = 0; j < 4; j++) {
				table[i][j] = i*4 + j+1;
				System.out.print(table[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
