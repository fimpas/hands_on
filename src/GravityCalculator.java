

class GravityCalculator {
	public static void main(String[] arguments){
		double gravity =-9.81; // Earth's gravity in m/s^2 
		double fallingTime = 10.0;
		double initialVelocity = 0.0; 
		double finalVelocity = gravity*fallingTime + initialVelocity;
		double initialPosition = 500.0; 
		double finalPosition = 0.5*gravity*fallingTime*fallingTime + initialVelocity*fallingTime + initialPosition;
		// Add the formulas for position and velocity
		System.out.println("The object's position after " + fallingTime + " seconds is " 
		+ finalPosition + " m.");
		// Add output line for velocity (similar to position)
		System.out.println("The object's velocity after " + fallingTime + " seconds is "
				+ -finalVelocity + " m/s");
		
	}
}