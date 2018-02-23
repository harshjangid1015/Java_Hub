package OOPs;

public class CopyConstructor {
	String web; 
	CopyConstructor(String w){  
		web = w;
	}  

	/* This is the Copy Constructor, it 
	 * copies the values of one object
	 * to the another object (the object
	 * that invokes this constructor)
	 */
	CopyConstructor(CopyConstructor je){  
		web = je.web; 
	}  
	void disp(){
		System.out.println("Website: "+web);
	}  

	public static void main(String args[]){  
		CopyConstructor obj1 = new CopyConstructor("BeginnersBook");  

		/* Passing the object as an argument to the constructor
		 * This will invoke the copy constructor
		 */
		CopyConstructor obj2 = new CopyConstructor(obj1);  
		obj1.disp();  
		obj2.disp();  
	} 
}
