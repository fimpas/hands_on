	
public class Manager_lec3 extends Employee_lec3 {
	// Create a constructor for the class with a method hasOffice
	
	String office;
	
	Manager_lec3(String name, char level, int hoursWorked, double basePay, String office) {
		super(name, level, hoursWorked, basePay);
		this.office = office;
	}
	void hasOffice() {
		if (level == 'A') {
			System.out.printf("Manager %s have an individual office. \n \n" , name);
		}
		else {
			System.out.printf("Manager %s have a cubicle. \n \n" , name);
		}
	}
	void msalary() {
		double msalary;
		if (hoursWorked > 40) {
			int i = hoursWorked - 40;
			msalary = basePay*40 + basePay*1.5*i;
		}
		else {
			msalary = basePay*hoursWorked;
		}
		System.out.printf("Manager %s has earned %.02f dollars. \n", name, msalary);
		if (basePay < 8) {
			System.out.printf("ERROR, employee %s base pay is below $8.00  \n", name);
		}
	}
	

}
