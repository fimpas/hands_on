package kNN;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class kNNmethod { 
	
	
	public static void main(String[] args) {
		  
		String dataFile = "iris.csv";
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";
		int test = 0;
		int learn = 0;
		
		int K = 3;
		
		ArrayList<Flower> flowerList = new ArrayList<Flower>();
		ArrayList<Flower> testList = new ArrayList<Flower>();
		ArrayList<Flower> learnList = new ArrayList<Flower>();
		

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
				if (learn<30) {
					learnList.add(new Flower(blomma[4], param));
					learn++;
				}
				else {
					testList.add(new Flower(blomma[4], param));
					test++;
					if (test==20) {
						learn=0;
						test=0;
					}
					
				}
				flowerList.add(new Flower(blomma[4], param)); // 4 is for the 4th input in blomma

				// Read each line of file and store data into database

			}
			System.out.println(learnList.size()+ " <- learn : test -> " + testList.size());

		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
			
////		 a test value
//		double[] query = {5.2, 3.3, 2.5, 0.4};
			
		// create object Result that contains distance to a specific flower and flower’s type
		ArrayList<String> testType = new ArrayList<String>();
		
		
		for(Flower t : testList) {
		
		ArrayList<Result> resultList = new ArrayList<Result>();
				
		for(Flower f : learnList) {
			double dist = 0.0;
			// with query
//			dist = Math.pow((f.param[0]-query[0]), 2) + Math.pow((f.param[1]-query[1]), 2)
//			+ Math.pow((f.param[2]-query[2]), 2) + Math.pow((f.param[3]-query[3]), 2);
			
//			 with test-set 
			dist = Math.pow((f.param[0]-t.param[0]), 2) + Math.pow((f.param[1]-t.param[1]), 2) +
					Math.pow((f.param[2]-t.param[2]), 2) + Math.pow((f.param[3]-t.param[3]), 2);
			
// calculate variable dist – square of Euclidean distance from query measurements to flower’s dimensional parameters
			
			double distance = Math.sqrt(dist);
			
			resultList.add(new Result(distance, f.type));
			}
			
		Collections.sort(resultList, new DistanceComparator());
		
		int c1=0, c2=0, c3=0;
		for (int i = 0; i<K; i++) {
			
			String c;
			c = resultList.get(i).label;
			switch(c) {
			case "Iris-setosa":
				c1++;
				break;
			case "Iris-versicolor":
				c2++;
				break;
			case "Iris-virginica":
				c3++;
				break;
			}
		}
		if (c1>c2) {
			if (c1>c3) {
				testType.add("Iris-setosa");
			}
			else {
				testType.add("Iris-virginica");
			}
		}
		else if (c2>c3) {
				testType.add("Iris-versicolor");
				}
		else {
				testType.add("Iris-virginica");
			}
		
//		System.out.println(c1 + " " + c2 + " " + c3);
		
		}
		System.out.println(testType.size());
		System.out.println(testList.size());

		for(int x = 0; x < testList.size(); x++) {
			System.out.println(testList.get(x).type + "\t " + testType.get(x));
		}
	}
}

