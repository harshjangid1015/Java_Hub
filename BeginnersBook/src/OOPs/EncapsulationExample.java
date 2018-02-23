package OOPs;

class EmployeeCount{
	private int numOfEmployee = 0;
	public void setNumOfEmploee (int count){
		numOfEmployee = count;
	}
	public int getNumOfEmployee() {
		return numOfEmployee;
	}
}

public class EncapsulationExample {
	public static void main(String[] args) {
		EmployeeCount obj = new EmployeeCount();
		obj.setNumOfEmploee(5613);
		System.out.println("No of Employee: " +obj.getNumOfEmployee());
	}
}
