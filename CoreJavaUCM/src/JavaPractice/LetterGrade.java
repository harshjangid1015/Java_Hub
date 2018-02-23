package JavaPractice;

import java.util.Scanner;

public class LetterGrade {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the score: ");
		double score = scan.nextDouble();
		char grade;
		
		if (score >= 90)
			grade = 'A';
		else if (score >=80 && score<90)
			grade = 'B';
		else if (score >=70 && score<80)
			grade = 'C';
		else if (score >=60 && score<70)
			grade = 'D';
		else
			grade = 'F';
		
		System.out.println("Your grade is: "+grade);
		
	}

}
