
public class Employee_lec3 {
	// Create a constructor for the class with 2 methods: salary, office
	String name;
	char level;	
	int hoursWorked;
	double basePay;
	
	// Constructor
	Employee_lec3(String name, char level, int hoursWorked, double basePay) {
		this.name = name;
		this.level = level;
		this.hoursWorked = hoursWorked;
		this.basePay = basePay;
	}
	// Method
	void salary() {
		double salary;
		if (hoursWorked > 40) {
			int i = hoursWorked - 40;
			salary = basePay*40 + basePay*1.5*i;
		}
		else {
			salary = basePay*hoursWorked;
		}
		System.out.printf("Employee %s has earned %.02f dollars. \n", name, salary);
		if (basePay < 8) {
			System.out.printf("ERROR, employee %s base pay is below $8.00  \n", name);
		}
	}
	void office() {
		if (level == 'A') {
			System.out.printf("Employee %s possess an individual office. \n \n", name);
		}
		else {
			System.out.printf("Employee %s possess a cubicle. \n \n", name);
		}
		
		
		
	}
	
}
