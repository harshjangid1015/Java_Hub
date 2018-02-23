package cs4120;
//Exercise 19.7
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GenericBinarySearch {
	public static void main(String[] args) {
		Integer[] randInt = new Integer[100];
		Random rand = new Random();
		for(int i =0; i<randInt.length; i++) {
			randInt[i] = rand.nextInt(100);
		}
		//displaying random Integers
		System.out.print("random integers: ");
		for(int i = 0; i<randInt.length; i++) {
			System.out.print(randInt[i] + ", ");
		}
		System.out.println();
		//sorting of array before Binary Search
		Arrays.sort(randInt);
		//displaying sorted array
		System.out.print("sorted integers: ");
		for(int i = 0; i<randInt.length; i++) {
			System.out.print(randInt[i] + ", ");
		}
		System.out.println();
		//Prompt the user to enter an integer.
		System.out.print("Enter an integer: ");
		Scanner scan = new Scanner(System.in);
		int intInput = scan.nextInt();

		if(binarySearch(randInt, intInput) >= 0) {
			System.out.println("input integer is in the array having index " + binarySearch(randInt, intInput));	
		}
		else {
			System.out.println("input integer is not present in the array");
		}

		//Generating random strings
		String Alphabets = "abcdefghijklmnopqrstuvwxyz";
		String[] randString = new String[5];
		for(int i = 0; i < randString.length; i++) {
			String Str1 = "";
			int randStrLen = 1 + rand.nextInt(10);
			for(int j = 0; j<randStrLen; j++) {
				char c = Alphabets.charAt(rand.nextInt(26));
				Str1 = Str1 + c;
				randString[i] =  Str1;
			}
		}
		System.out.println();
		//display of strings
		System.out.print("random strings: ");
		for(int i = 0; i<randString.length; i++) {
			System.out.print(randString[i] + ", ");
		}
		System.out.println();
		//sorting of array before Binary Search
		Arrays.sort(randString);
		//displaying sorted array
		System.out.print("sorted strings: ");
		for(int i = 0; i<randString.length; i++) {
			System.out.print(randString[i] + ", ");
		}
		System.out.println();
		//Prompt the user to enter a string.
		System.out.print("Enter an String: ");
		String strInput = scan.next();
		//Use binarySearch() to check if the string is in the array.
		if(binarySearch(randString, strInput) >= 0) {
			System.out.println("input string is in the array having index " + binarySearch(randString, strInput));	
		}
		else {
			System.out.println("input string is not present in the array");
		}


		Employee[] employee = new Employee[7];
		String[] fname = new String[employee.length];
		String[] lname = new String[employee.length];
		Integer[] sal = new Integer[employee.length];
		
		for(int i = 0; i < employee.length; i++) {
			int name_length = 4 + rand.nextInt(8);
			String Str1 = "";
			String Str2 = "";			
			for(int j = 0; j<name_length; j++) {
				char c = Alphabets.charAt(rand.nextInt(26));
				char d = Alphabets.charAt(rand.nextInt(26));				
				Str1 = Str1 + c;
				Str2 = Str2 + d;				
			}			
			sal[i] = 25000 + rand.nextInt(25000);
			fname[i] =  Str1;
			lname[i] = Str2;			
			employee[i] = new Employee(fname[i], lname[i], sal[i]);			
		}
		
		System.out.println();
		System.out.println("------------------------- ");
		System.out.println("Displaying Employees FirstName, LastName, Salary");
		System.out.println("------------------------- ");
		//		displaying employees	
		for(int i = 0; i<employee.length; i++) {
			System.out.println(employee[i].first_name + "\t " + employee[i].last_name + "\t " + employee[i].salary);
		}
		System.out.println();		
		System.out.println("------------------------- ");
		//Sorting Employee object array
		System.out.println("Sorted Employee Object Array");
		System.out.println("------------------------- ");
		Arrays.sort(employee);
		for(int i = 0; i<employee.length; i++) {
			System.out.println(employee[i].first_name + "\t " + employee[i].last_name + "\t " + employee[i].salary);
		}
		System.out.println("------------------------- ");
		
		//Prompt the user to enter the first name and last name to search the array with binarySearch().
		System.out.println("Enter the First Name and Last Name to check in array: ");		
		String fnInput = scan.next();
		String lnInput = scan.next();		
		Employee e = new Employee(fnInput, lnInput, 0);
		
		if((binarySearch(employee, e) >= 0)) {
			System.out.println("input name is present in the employee array" );
			System.out.println("Index of emplyee in sorted array is: " + binarySearch(employee, e));
		}
		else {
			System.out.println("input name is not present in the employee object array");
		}
		scan.close();
	}
	public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
		int low = 0;
		int high = list.length - 1;
		while (high >= low) {
			int mid = (low + high) / 2;
			if(key.compareTo(list[mid]) < 0)
				high = mid - 1;
			else if (key.compareTo(list[mid]) == 0)
				return mid;
			else
				low = mid + 1;
		}
		return -low - 1;
	}
}


class Employee implements Comparable {
	String first_name = "";
	String last_name = "";
	Integer salary = 0;

	public Employee(String first_name, String last_name, Integer salary) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.salary = salary;
	}

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}	
	@Override
	public int compareTo(Object anotherEmployee) throws ClassCastException {			
		Employee e = (Employee)anotherEmployee;
		 
		if(this.first_name.equals(e.getFirst_name()))
		    {
		        return this.last_name.compareTo(e.getLast_name());
		    }
		    else
		    {
		        return this.first_name.compareTo(e.getFirst_name());
		    }			
	}
}
