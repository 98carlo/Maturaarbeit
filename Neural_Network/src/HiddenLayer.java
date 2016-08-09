import java.util.ArrayList;

public class HiddenLayer {
	
	private ArrayList <Neuron> ListOfNeurons = new ArrayList <Neuron> ();
	private int NumberOfNeuronsInLayer;
	
	public ArrayList <HiddenLayer> initLayer (HiddenLayer hiddenLayer,ArrayList <HiddenLayer> listOfHiddenLayer,InputLayer inputLayer, OutputLayer outputLayer){
		//initializes Layer with a specific number of Neurons
		Layer layer = new Layer();
		int NumberOfNeuronsInInputLayer = inputLayer.getNumberOfNeuronsInLayer();
		int NumberOfNeuronsInOutputLayer = outputLayer.getNumberOfNeuronsInLayer();
		for ( int i = 0; i < NumberOfNeuronsInLayer; i++){
			Neuron neuron = new Neuron();
			neuron = neuron.initNeuron(NumberOfNeuronsInInputLayer, NumberOfNeuronsInOutputLayer, neuron);
			ListOfNeurons.add(neuron);
		}
		layer.setListOfNeurons(ListOfNeurons);
		//adds the hiddenLayer to the listOfHiddenLayer if I need several HiddenLayers
		listOfHiddenLayer.add(hiddenLayer);
		//returns the list
		return listOfHiddenLayer;
		
	}
	
	public void printLayer (HiddenLayer hiddenLayer){
		for (int i = 0; i < NumberOfNeuronsInLayer ; i++){
			int x = i++;
			System.out.println(x + ". Neuron");
			Neuron neuron = ListOfNeurons.get(i);
			System.out.println("Input: ");
			System.out.println(neuron.getlistOfWeightIn().toString());
			System.out.println("Output: ");
			System.out.println(neuron.getListOfWeightOut().toString());
			}
		}
	
}
