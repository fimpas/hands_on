package neural;

import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import kNN.Flower;

public class Ann {
	
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		
		int stop =0, count=0, correct=0;
		String dataFile = "iris.csv";
		BufferedReader br = null;
		String line = "";
		String SplitBy = ",";
		double errorRef =0.01001;
		Random rand = new Random();
		
		Layers inputLayer = new Layers(4,12,null); 
		Layers hiddenLayer = new Layers(3,9,inputLayer); 
		Layers outLayer = new Layers(3,0,hiddenLayer);
		
		        //Assign Random weights to the neurons
		double[] weightsInput = {
				21.37123624669344, -26.186549112980575, -19.794032077000804, 
				21.05158657051977, 4.277107726994438, -2.422682345606089,
				-7.419328126739197, 0.9754819516159747, -3.560322624750524,
				9.520770615484489, -8.67830086202733, -10.384748030894867}; 
		
		double[] weightsHidden = {
				-18.256996831057503, 0.2795991110558273, 5.483710481334243, 
				-6.920389193587981, 68.30668042401328, -32.50914610254647,
				7.236796659011301, -71.49483378755768, -16.07151532099132}; 
		
		inputLayer.setWeights(weightsInput);
		hiddenLayer.setWeights(weightsHidden);
		
		ArrayList<neural.Flower> flowerList = new ArrayList<neural.Flower>(); 
		ArrayList<neural.Flower> learnList = new ArrayList<neural.Flower>(); 
		ArrayList<neural.Flower> testList = new ArrayList<neural.Flower>();

		try {
		// use code from Java exercise IV to create internal database of iris flowers
			br = new BufferedReader(new FileReader(dataFile));
			
			while ((line = br.readLine()) != null) {
	 	     // use comma as separator
				String[] flower = line.split(SplitBy);
				double[] param = {0.0,0.0,0.0,0.0};
				double outType[]={0,0,0};

				
				for (int j = 0; j < 4; j++)	{				
					param[j] = Double.parseDouble(flower[j]);
					}
				if (flower[4] == "Iris-setosa") {
					outType[0] = 1;
				}
				else if (flower[4] == "Iris-versicolor") {
					outType[1] = 1;
				}
				else {
					outType[2] = 1;
				}
				
				
				flowerList.add(new neural.Flower(param, flower[4], outType));
			}
		}

				
		catch (FileNotFoundException e) {
		            e.printStackTrace(); 
		            } 
		catch (IOException e) {
			e.printStackTrace();
			}
		
		normalizeData(flowerList);
		
		while(count<learnList.size()) { 
			count=0;
			stop++;
			ArrayList<Double> error = new ArrayList<Double>();
			
			for(int i=0;i<learnList.size();i++){
				feedForward(inputLayer,hiddenLayer,outLayer,learnList.get(i),i); 
				error.add(calError(outLayer,learnList.get(i),i)); 
				if(error.get(i)<errorRef){
					count++; 
					}
				}
			error.clear();
			if(stop==3000)
				break;
			clearValues(inputLayer,hiddenLayer,outLayer);
			} 
		clearValues(inputLayer,hiddenLayer,outLayer);
		        
		
		// Test the developed neural network with the test set
		}
	}
		public static void normalizeData(ArrayList<neural.Flower> flowerList){
		// write code for normalizing the data
		}
		public static void clearValues(Layers input, Layers hidden, Layers output){
		//clear the values at each node for the next iteration
		}
		public static double calError(Layers output, Flower fl, int index){
		        double error=0;
		//calculate the error between the neural network output and target values
		        return error;
		    }
		public static void feedForward(Layers input, Layers hidden, Layers output, Flower fl, int index){
		        //calculate the value at every node
		}


}
