import java.util.ArrayList;

public class InputLayer {

	
	private int numberOfNeuronsInLayer;
	private static ArrayList <Neuron> ListOfNeurons;
	
	public InputLayer initLayer (InputLayer inputLayer){
		Layer layer = new Layer();
		int NumberOfWeightIn = 2;
		for (int i = 0; i < numberOfNeuronsInLayer; i ++){
			Neuron neuron = new Neuron();
			neuron.initNeuron(NumberOfWeightIn, 0, neuron);
			ListOfNeurons.add(neuron);
		}
		layer.setListOfNeurons(ListOfNeurons);
		return inputLayer;	                                                                                          
	} 
	
	void printLayer(InputLayer inputLayer){
		System.out.println("------ InputLayer ------");
		System.out.println(inputLayer.toString());
	}
	
	public void setNumberOfNeuronsInLayer (int numberOfNeuronsInLayer){
		this.numberOfNeuronsInLayer = numberOfNeuronsInLayer;
	}
	
	public int getNumberOfNeuronsInLayer(){
		return numberOfNeuronsInLayer;
	}

	public void setListOfNeurons (ArrayList<Neuron> teachNeuronsOfLayer) {
		 for (int i = 0; i < numberOfNeuronsInLayer; i++){
			 ListOfNeurons.add(i, teachNeuronsOfLayer.get(i));
		 }
		
	}

	public ArrayList<Neuron> getlistOfNeurons() {
		return ListOfNeurons;
	}

}
