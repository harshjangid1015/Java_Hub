package javaCW;

public class PhoneDemo {
	public static String searchPhone(String[][] records, String name) {
		for(int i=0; i<records.length; i++) {
			if (records[i][0].trim().equalsIgnoreCase(name.trim())) {
				return records[i][1];
			}
//			else if(records[i][0].equals(name.trim())) {
//				return records[i][1];
//			}
//			else if(records[i][0].equals(name.equalsIgnoreCase(name))) {
//				return records[i][1];
//			}
		}
		return null;	
	}
	
	public static void main(String[] args) {
		String phoneBook [][] = {
				{"Tom", "555-3322"},
				{" Mary ", "555-8976"},
				{"Jon", "555-1037"},
				{"Rachel", "555-1400"}
				
		};
		System.out.println(searchPhone(phoneBook, "Mary"));
		System.out.println(searchPhone(phoneBook, "mary"));
		System.out.println(searchPhone(phoneBook, " Jon "));
		System.out.println(searchPhone(phoneBook, "Andy"));
	}

}
