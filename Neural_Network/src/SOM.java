import java.util.ArrayList;

public class SOM {
	
	public NeuralNet trainNet(NeuralNet n){
		
		//getting the Training Data
		double [] [] TrainData = n.getTrainSet();
		//figuring it's size out
		int row = TrainData.length;
		int cols = TrainData[0].length;
		
		ArrayList <Double> ListOfDistances = new ArrayList <Double> ();
		
		for ( int epochs = 0; epochs < n.getMaxEpochs(); epochs++){
			
		}
		
		return n;
	}
	
	private ArrayList <Double> calcEuclideanDistance (NeuralNet n, double [] [] TrainData, int RowOfTrainData){
		
		ArrayList <Double> ListOfDistances = new ArrayList <Double>();
		
		for ( int cluster_i = 0; cluster_i < n.getOutputLayer().getNumberOfNeuronsInLayer(); cluster_i++){
			
			double distance = 0.0;
			HiddenLayer hiddenLayer = n.getHiddenLayer(n, 0);
			
			for ( int input_i = 0; input_i < hiddenLayer.getNumberOfNeuronsInLayer(); input_i ++){
				ArrayList <Double> ListOfWeightOut = n.getInputLayer().getlistOfNeurons().get(input_i).getListOfWeightOut();
				
				for (int weight_i = 0; weight_i < ListOfWeightOut.size(); weight_i++){
				
					double weight = ListOfWeightOut.get(weight_i);
					distance = distance + Math.pow(TrainData [RowOfTrainData] [input_i] - weight, 2);
					
				}
				
			}
			
			ListOfDistances.add(distance);
			
		}
		
		return ListOfDistances;
	}
	
	private NeuralNet FixWinnerWeights (NeuralNet n){
		
		
		return n;
		
	}
	
	

}
