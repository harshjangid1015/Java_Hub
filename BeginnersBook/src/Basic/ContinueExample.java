package Basic;

public class ContinueExample {
	public static void main(String[] args) {
		for(int j=0; j<=6; j++) {
			if(j==4) {	//to escape 4
				continue;
			}
			System.out.print(j+ " ");
		}
	}
}
