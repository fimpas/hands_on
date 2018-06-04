import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DecisionTree {
	

	public static void main(String[] args) {

		String dataFile = "iris.csv";
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";
		ArrayList<Flower> flowerList = new ArrayList<Flower>(); 
		
		try {
// use code from Java exercise IV to create internal database of iris flowers
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
			}
		} 
		catch (FileNotFoundException e) { 
			e.printStackTrace();
		}
		catch (IOException e) { 
			e.printStackTrace();
		}
// print out a list with one of the dimensional parameters
		
//create 2 new ArrayLists to split original

		ArrayList<Flower> irisList1 = new ArrayList<Flower>(); 
		ArrayList<Flower> irisList2 = new ArrayList<Flower>();
		ArrayList<Flower> irisList3 = new ArrayList<Flower>(); 
		ArrayList<Flower> irisList4 = new ArrayList<Flower>();
		ArrayList<Flower> irisList5 = new ArrayList<Flower>(); 
		ArrayList<Flower> irisList6 = new ArrayList<Flower>();
		ArrayList<Flower> irisList7 = new ArrayList<Flower>(); 
		ArrayList<Flower> irisList8 = new ArrayList<Flower>();
		ArrayList<Flower> irisList9 = new ArrayList<Flower>(); 
		ArrayList<Flower> irisList10 = new ArrayList<Flower>();		
		ArrayList<Flower> irisList11 = new ArrayList<Flower>(); 
		ArrayList<Flower> irisList12 = new ArrayList<Flower>();
// define an optimal split point to get maximum entropy gain
		
//		showList(flowerList,3); // 		BASE
		splitByGain(flowerList, 1.8, irisList1, irisList2, 3); // array, double splitValue, array, array,  int splitParameter 
		
		System.out.println("1 - Group1 - Versicolor : " + frequency(irisList1, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList1, "Iris-virginica") + " \t" + "Other : " + (irisList1.size()-(frequency(irisList1, "Iris-versicolor") + frequency(irisList1, "Iris-virginica"))));
		System.out.println("2 - Group2 - Versicolor : " + frequency(irisList2, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList2, "Iris-virginica") + " \t" + "Other : " + (irisList2.size()-(frequency(irisList2, "Iris-versicolor") + frequency(irisList2, "Iris-virginica"))) + "\n");

		// find other split points to develop decision tree algorithm
		
//		showList(irisList1, 1); // 		BASE - Y
		splitByGain(irisList1, 5.1, irisList3, irisList4, 2); // array, double splitValue, array, array,  int splitParameter 
		
		System.out.println("1 - Group1 - Versicolor : " + frequency(irisList3, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList3, "Iris-virginica") + " \t" + "Other : " + (irisList3.size()-(frequency(irisList3, "Iris-versicolor") + frequency(irisList3, "Iris-virginica"))));
		System.out.println("1 - Group2 - Versicolor : " + frequency(irisList4, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList4, "Iris-virginica") + " \t" + "Other : " + (irisList4.size()-(frequency(irisList4, "Iris-versicolor") + frequency(irisList4, "Iris-virginica")))+ "\n");

//		showList(irisList3, 2);			BASE - Y - Y
		splitByGain(irisList3, 2.6, irisList7, irisList8, 1); // array, double splitValue, array, array,  int splitParameter 
//		
		System.out.println("3 - Group1 - Versicolor : " + frequency(irisList7, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList7, "Iris-virginica") + " \t" + "Other : " + (irisList7.size()-(frequency(irisList7, "Iris-versicolor") + frequency(irisList7, "Iris-virginica"))));
		System.out.println("3 - Group2 - Versicolor : " + frequency(irisList8, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList8, "Iris-virginica") + " \t" + "Other : " + (irisList8.size()-(frequency(irisList8, "Iris-versicolor") + frequency(irisList8, "Iris-virginica")))+ "\n");

//		showList(irisList4, 3); // 		BASE - Y - N
		splitByGain(irisList4, 6.1, irisList9, irisList10, 0); // array, double splitValue, array, array,  int splitParameter 
//		
		System.out.println("4 - Group1 - Versicolor : " + frequency(irisList9, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList9, "Iris-virginica") + " \t" + "Other : " + (irisList9.size()-(frequency(irisList9, "Iris-versicolor") + frequency(irisList9, "Iris-virginica"))));
		System.out.println("4 - Group2 - Versicolor : " + frequency(irisList10, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList10, "Iris-virginica") + " \t" + "Other : " + (irisList10.size()-(frequency(irisList10, "Iris-versicolor") + frequency(irisList10, "Iris-virginica")))+ "\n");
//
//		showList(irisList2, 0); // 		BASE - N 
		splitByGain(irisList2, 6.0, irisList5, irisList6, 0); // array, double splitValue, array, array,  int splitParameter 
		
		System.out.println("2 - Group1 - Versicolor : " + frequency(irisList5, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList5, "Iris-virginica") + " \t" + "Other : " + (irisList5.size()-(frequency(irisList5, "Iris-versicolor") + frequency(irisList5, "Iris-virginica"))));
		System.out.println("2 - Group2 - Versicolor : " + frequency(irisList6, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList6, "Iris-virginica") + " \t" + "Other : " + (irisList6.size()-(frequency(irisList6, "Iris-versicolor") + frequency(irisList6, "Iris-virginica")))+ "\n");

//		
//		showList(irisList5, 1); // 		BASE - N - Y
		splitByGain(irisList5, 4.9, irisList11, irisList12, 2); // array, double splitValue, array, array,  int splitParameter 
		
		System.out.println("5 - Group1 - Versicolor : " + frequency(irisList11, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList11, "Iris-virginica") + " \t" + "Other : " + (irisList11.size()-(frequency(irisList11, "Iris-versicolor") + frequency(irisList11, "Iris-virginica"))));
		System.out.println("5 - Group2 - Versicolor : " + frequency(irisList12, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList12, "Iris-virginica") + " \t" + "Other : " + (irisList12.size()-(frequency(irisList12, "Iris-versicolor") + frequency(irisList12, "Iris-virginica")))+ "\n");

//		splitByGain(irisList11, 3.1, irisList11, irisList12, 1); // array, double splitValue, array, array,  int splitParameter 
//		
//		System.out.println("5 - Group1 - Versicolor : " + frequency(irisList11, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList11, "Iris-virginica") + " \t" + "Other : " + (irisList11.size()-(frequency(irisList11, "Iris-versicolor") + frequency(irisList11, "Iris-virginica"))));
//		System.out.println("5 - Group2 - Versicolor : " + frequency(irisList12, "Iris-versicolor") + " \t" + "Virginica : " + frequency(irisList12, "Iris-virginica") + " \t" + "Other : " + (irisList12.size()-(frequency(irisList12, "Iris-versicolor") + frequency(irisList12, "Iris-virginica")))+ "\n");

		int correct = 0;
		for (int i = 0; i < flowerList.size(); i++) {
			String flower;
			flower = getInfo(flowerList.get(i));
			if(flower.equals(flowerList.get(i).type)) {
				correct++;
			}
		}
		double corr = 100*correct/(frequency(flowerList, "Iris-versicolor") + frequency(flowerList, "Iris-virginica"));
		System.out.println("\n Number of correct flowers : " + correct + "\n With procentage of : " + corr + "%");
		
		
	}	
	
// a method to count a number of a specific species in a flower list
	
	public static String getInfo(Flower blomma) {
		String flower = null;
		
		if (blomma.param[3]<1.8) {
			if(blomma.param[2]<5.1) {
				if(blomma.param[1]<2.6) {
					flower = "Iris-versicolor";	
				}
				else {
					flower = "Iris-versicolor";
				}
			}
			else {
				if(blomma.param[0]<6.1) {
					flower = "Iris-versicolor"; // "Iris-virginica"
				}
				else {
				flower = "Iris-virginica"; // "Iris-virginica"
				}
			}
			
		}
		else {
			if (blomma.param[0]<6.0) {
				if(blomma.param[2]<4.9) {
					flower = "Iris-versicolor";
				}
				else {
					flower = "Iris-virginica";
				}
			}
			else {
				flower = "Iris-virginica";
			}
		}
		
		return flower;
	}

public static int frequency (ArrayList<Flower> flowerList, String name) {
	
	int count=0;
	for (Flower e : flowerList) {
		if (e.type.equals(name)) {
			count = count+1;
		}
	}
	// count apperances in the list
	return count; 
	}

	// a method to calculate entropy of split

public static double entropy (ArrayList<Flower> flowerList){
	double total_number = flowerList.size();
	double Virginica_number = frequency(flowerList, "Iris-virginica"); 
	double Versicolor_number = frequency(flowerList, "Iris-versicolor");
	double prob_virg = Virginica_number/total_number; 
	double prob_vers = Versicolor_number/total_number;
	double Entropy_total = 0;
	
	if (prob_vers == 0) {
		Entropy_total = -prob_virg*Math.log(prob_virg)/Math.log(2);
		
	}
	else if (prob_virg == 0) {
		Entropy_total = -prob_vers*Math.log(prob_vers)/Math.log(2);
	}
	else {
		Entropy_total = -(prob_virg*Math.log(prob_virg)/Math.log(2))-(prob_vers*Math.log(prob_vers)/Math.log(2));
	}
	
	// calculate total entropy

	return Entropy_total;
}


	// a method to calculate information gain of the split
	
public static void splitByGain (ArrayList<Flower> flowerList, double splitValue, ArrayList<Flower> irisList1, 
			ArrayList<Flower> irisList2, int splitParameter) {
	
	double flowerSize = flowerList.size(); 
	double entropyTotal = entropy(flowerList);
	
	// split a list of Flowers based on a splitParameter and SplitValue
	for (Flower f : flowerList) 
		
		if (f.param[splitParameter]<splitValue) { //////////////////////
			irisList1.add(f);
		}
		else {
			irisList2.add(f);
		}
	
	double iris1size = irisList1.size(); 
	double iris2size = irisList2.size(); 
	double entropy1 = entropy(irisList1); 
	double entropy2 = entropy(irisList2);
	
	double gain = entropyTotal - (iris1size*entropy1/flowerSize + iris2size*entropy2/flowerSize);
			// calculate information gain 
	System.out.println("Previous Entropy : " + entropyTotal);
	System.out.println("New Entropy : " + (iris1size*entropy1/flowerSize + iris2size*entropy2/flowerSize));
	System.out.println("Gain of the split : " + gain);

}
	
public static void showList(ArrayList <Flower> flowerList, int posit) {
	System.out.println("\n\n\n");
	for(int x = 0; x < flowerList.size(); x++){
		System.out.println(flowerList.get(x).type + " ... " + flowerList.get(x).param[posit]);
		}
	}
}



