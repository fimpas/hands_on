
public class GravCalcExtended {

	public static double multi(double x, double y){ // method for multiplication
		// add 2 more methods for powering to square and summation (similar to multiplication)

		return x*y;
	}
	public static double square(double x) {
		return x*x;
	}
	public static double sum(double x, double y) {
		return x+y;
	}
	
	public static void outline(double z,double x, double y){  // method for printing out a result
		System.out.println("The object's position after " + z + " seconds is " 
				+ x + " m, with the velocity " + -y + " m/s.");
	}
	public static void main(String[] arguments) {
		// compute the position and velocity of an object with defined methods and print out the result
		double gravity = -9.81; // Earth's gravity in m/s^2 
		double fallingTime = 10;
		double initialVelocity = 0.0; 
//		double finalVelocity = gravity*fallingTime + initialVelocity;
		double initialPosition = 500.0; 
//		double finalPosition = 0.5*gravity*fallingTime*fallingTime + initialVelocity*fallingTime + initialPosition;
		// Add the formulas for position and velocity
		double x = sum(sum(multi(0.5,multi(gravity,square(fallingTime))), multi(initialVelocity,fallingTime)),initialPosition);
		double v = sum(multi(gravity,fallingTime), initialVelocity);
		outline(fallingTime,x,v);
	}


}

//The object's position after 10.0 seconds is 9.499999999999943 m.
//The object's velocity after 10.0 seconds is 98.10000000000001 m/s



