import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//algorithm which is mainly used for clustering data
//perfect for behavior predictions 

public class Kohonen {
	
	public NeuralNet train (NeuralNet n){
		//initiating the NeuralNetwork
		initNet(n);
		//getting the TrainSet and its Length
		double [] [] trainData = n.getTrainSet();
		int rows = trainData.length;
		int cols = trainData[0].length;
		//Kohonen works mostly with the distances of the values
		ArrayList <Double> listOfDistances = new ArrayList <Double>();
		//stops when it reaches the MaxEpochs
		//would be also able to stop with a certain amount of Weight-updates but it's a lot harder to control
		for (int epoch = 0; epoch < n.getMaxEpochs(); epoch++){
			
			for (int row_i = 0; row_i < rows; row_i++){
				//trainData needs to be implemented
				//create local variable and import trainData
				//declare the best distance
				listOfDistances = calcEuclideanDistance(n, trainData, row_i);
				//Kohonen works with BMU (best matching Unit) here called winnerNeuron for a less confusing code
				int winnerNeuron = listOfDistances.indexOf (Collections.min(listOfDistances));
				//fixing the Weights of the BMU and the Weights/Neurons next to it
				n = fixWinnerWeights (n, winnerNeuron, row_i);
			}
		}
		return n;
	}
	
	private NeuralNet initNet (NeuralNet n){
		//initiating the Neural Network
		//whole code is in the NeuralNet class
		n.initNet();
		//returns the initialized Network
		return n;
	}
	
	private ArrayList <Double> calcEuclideanDistance (NeuralNet n, double [] [] data, int row){
		//declaring an ArrayList for saving the Distances and for the weight I want to get from the ListOfWeightOut
		ArrayList <Double> listOfDistances = new ArrayList <Double>();
		int weight_i = 0;
		//for-Loop for going through every weight and declaring every single distance
		for (int cluster_i = 0; cluster_i < n.getOutputLayer().getNumberOfNeuronsInLayer(); cluster_i++){
			
			double distance = 0.0;
			
			for (int input_j = 0; input_j < n.getInputLayer().getNumberOfNeuronsInLayer(); input_j++){
				
				double weight = n.getInputLayer().getlistOfNeurons().get(0).getListOfWeightOut().get(weight_i);
				distance = distance + Math.pow(data[row][input_j] - weight, 2.0);
				weight_i++;
			}
			//adding the distance into the ArrayList of the listOfDistances
			listOfDistances.add(distance);
		}
		return listOfDistances;
	}
	
	private NeuralNet fixWinnerWeights (NeuralNet n, int winnerNeuron, int trainSetRow){
		//fixing the Weight of the BMU and its adjacent Neurons and their Weights
		//integers used for declaring where to start searching and where to end
		int start, last;
		//defining start and last
		start = winnerNeuron * n.getInputLayer().getNumberOfNeuronsInLayer();
		/*if (start < 0){
			start = 0;
		}*/
		
		last = start + n.getInputLayer().getNumberOfNeuronsInLayer();
		//declaring a variable for the Old Weights
		List<Double>listOfOldWeights = new ArrayList<Double>();
		listOfOldWeights = n.getInputLayer().getlistOfNeurons().get(0).getListOfWeightOut().subList(start, last);
		//declaring a variable for the new Weights
		ArrayList<Double>listOfWeights = new ArrayList<Double>();
		listOfWeights = n.getInputLayer().getlistOfNeurons().get(0).getListOfWeightOut();
		int col_i = 0;
		//replacing the Weights in the ArrayList with the new Weights and copying it into the listOfWeights
		for (int j = start; j < last; j++){
			double trainSetValue = n.getTrainSet()[trainSetRow][col_i];
			double newWeight = listOfOldWeights.get(col_i) + n.getLearningRate() * (trainSetValue - listOfOldWeights.get(col_i));
			listOfWeights.set(j, newWeight);
			col_i++;
		}
		n.getInputLayer().getlistOfNeurons().get(0).setListOfWeightOut(listOfWeights);
		return n;
	}
}
