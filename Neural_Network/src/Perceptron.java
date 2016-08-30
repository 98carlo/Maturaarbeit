import java.util.ArrayList;

public class Perceptron {
	public NeuralNet trainNet (NeuralNet n){
		double learningRate = n.getLearningRate();
		double [] estimatedOutputData = n.getEstimatedOutputData();
		double [] [] trainSet = n.getTrainSet();
		int NumberOfNeuronsInInputLayer = n.getInputLayer().getNumberOfNeuronsInLayer();
		double trainingError = 0;
		
		
		for (int neuron_i = 0; neuron_i < NumberOfNeuronsInInputLayer; neuron_i++){
			Neuron neuron = n.getInputLayer().getlistOfNeurons().get(neuron_i);
			for (int weight_i = 0; weight_i < neuron.getlistOfWeightIn().size() ; weight_i ++){
				trainingError = trainingError + neuron.getlistOfWeightIn().get(weight_i);
			}
			trainingError = trainingError - estimatedOutputData[neuron_i];
			n = fixWeights(n, trainingError, trainSet, learningRate, neuron_i);
		}
		return n;
	}
	
	private NeuralNet fixWeights (NeuralNet n, double trainingError, double [][] trainSet, double learningRate, int neuron_i){
		
		ArrayList <Double> ListofOldWeightIn = n.getInputLayer().getlistOfNeurons().get(neuron_i).getlistOfWeightIn();
		ArrayList <Double> ListofNewWeightIn = new ArrayList <Double>();
		
		return n;
	}
}
