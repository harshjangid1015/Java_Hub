package JavaPractice;

public class CalculateDistance {
	static int abs(int n) {
		if(n >= 0) return n;
		return -n;
	}
	public static void main(String[] args) {
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if(abs(i-j) > 1)
					System.out.println("i="+i+" j="+j+" far");
				else
					System.out.println("i="+i+" j="+j+" close");
		
	}
}
