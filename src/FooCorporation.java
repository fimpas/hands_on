
public class FooCorporation {

	public static void main(String[] args) {
		Employee john = new Employee("John", 7.50, 38);
		//		john.name = "John";
		//		// define the rest parameters for John
		//		john.basePay = 7.50;
		//		john.hoursWorked = 38;

		//Define 2 more Employees
		Employee annabel = new Employee("Annabel", 8.20, 42);
		//		annabel.name = "Annabel";
		//		annabel.basePay = 8.20;
		//		annabel.hoursWorked = 42;
		Employee graham = new Employee("Graham", 10.50, 41);

		//Define 2 more Managers
		Manager bill = new Manager("Bill", 15.50, 39, "A332");

		Manager gregory = new Manager("Gregory", 18.20, 40, "A415");

		john.salary();
		annabel.salary();
		graham.salary();
		bill.salary();
		gregory.salary();

		bill.office();
		gregory.office();
		

	}
}

class Employee {
	// Define fields
	String name;
	double basePay;
	int hoursWorked;

	//Create constructor
	Employee(String name, double basePay, int hoursWorked) {
		this.name = name;
		this.basePay = basePay;
		this.hoursWorked = hoursWorked;
	}
	void salary() {
		double salary;
		salary = basePay*hoursWorked;
		System.out.printf("%s earned %.02f dollars. \n", name, salary);
	}
}
class Manager extends Employee {
	// Create constructor for the class with an additional field officeNumber
	String officeNumber;
	Manager(String name, double basePay, int hoursWorked, String officeNumber) {
		super(name, basePay, hoursWorked);
		this.officeNumber = officeNumber;
	}
	void office() {
		System.out.printf("%s works in %s office. \n", super.name, officeNumber);
	}
}