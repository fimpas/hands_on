import java.util.ArrayList;
//import java.util.Arrays;

public class FooCorp_lec3 {

	
	public static void main(String[] args) {
		// Define parameters of employees given in the table

		String[] eName = {"John", "Graham", "Annabel", "Margaret"};
		char[] eLevel = {'B', 'B', 'A', 'B'};
		int[] eWork = {35, 37, 43, 45};
		double[] ePay = {8.5, 9.0, 9.2, 7.8};
		
		ArrayList<Employee_lec3> employeeList = new ArrayList<Employee_lec3>();
		
		String[] mName = {"Bill", "Gregory"};
		char[] mLevel = {'A', 'A'};
		int[] mWork = {49, 47};
		double[] mPay = {15.0, 16.5};
		String[] mOffice = {"A332", "A415"};
		
		ArrayList<Manager_lec3> managerList = new ArrayList<Manager_lec3>();
		
		
		for(int i=0; i < eName.length; i++) {
			// Create an object for each employee with relevant parameters
			employeeList.add(new Employee_lec3(eName[i], eLevel[i], eWork[i], ePay[i]));
			System.out.println(employeeList.toString());

		}
		
		for(int i=0; i < mName.length; i++) {
			managerList.add(new Manager_lec3(mName[i], mLevel[i], mWork[i], mPay[i], mOffice[i]));
			
		}
		
		for ( Employee_lec3 e : employeeList) { // Use enhance looping
			e.salary();
			e.office();

			// Compute salary and define a working place for each employee	
		}
		
		for ( Manager_lec3 m : managerList) {
			m.msalary();
			m.hasOffice();
			System.out.println(m);

		}
		System.out.println(eName[0] +  eName[1]);

		
	}
	
}

