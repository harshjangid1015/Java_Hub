package OOPs;

/*
 * The derived class inherits all the members and methods that are declared as public or 
 * protected. If the members or methods of super class are declared as private then the 
 * derived class cannot use them directly. The private members can be accessed only in its 
 * own class. Such private members can only be accessed using public or protected getter 
 * and setter methods of super class as shown in the example below.
 */

class Teacher {
	private String designation = "Teacher";
	private String collegeName = "Beginnersbook";
	public String getDesignation() {
		return designation;
	}
	protected void setDesignation(String designation) {
		this.designation = designation;
	}
	protected String getCollegeName() {
		return collegeName;
	}
	protected void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	void does(){
		System.out.println("Teaching");
	}
}
public class InheritanceExample extends Teacher {
	String mainSubject = "Physics";
	public static void main(String args[]){
		InheritanceExample obj = new InheritanceExample();
		/* Note: we are not accessing the data members 
		 * directly we are using public getter method 
		 * to access the private members of parent class
		 */
		System.out.println(obj.getCollegeName());
		System.out.println(obj.getDesignation());
		System.out.println(obj.mainSubject);
		obj.does();
	}
}
