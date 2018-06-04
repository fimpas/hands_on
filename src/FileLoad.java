import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileLoad {

	public static void main(String[] args) {

		String dataFile = "iris.csv";
		// Define buffer and split element
		
		BufferedReader br; 
		String line = null;
		String splitBy = ",";
		
		ArrayList<Flower> flowerList = new ArrayList<Flower>();
		

		// Create and ArrayList for Flowers (flowerList) 
		try {
			FileReader fr = new FileReader(dataFile);
			br = new BufferedReader(fr); // load a file into buffer
			
			// Cycle through the file
			while ((line = br.readLine()) != null) {
				String[] blomma = line.split(splitBy);
				double[] param = {0.0, 0.0, 0.0, 0.0};
				
				for (int i=0; i<4; i++) {
					param[i] = Double.parseDouble(blomma[i]);
				}
				flowerList.add(new Flower(blomma[4], param)); // 4 is for the 4th input in blomma

				// Read each line of file and store data into database
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
//		br.close();
		
		System.out.println(" Type \t \t Sepal length \t Sepal width \t Petal length \t Petal width ");
		
		for(Flower f: flowerList) {
			System.out.printf(" %s \t %f \t %f \t %f \t %f \n", f.type, f.param[0], f.param[1], f.param[2], f.param[3]);
		}
		
			// Print out fields of flowerList elements. To get element of ArrayList, command
//			flowerList.get(i) can be used. Remember to read fields of the objects. 
	}
}




