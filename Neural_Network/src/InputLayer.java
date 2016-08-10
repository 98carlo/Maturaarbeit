import java.util.ArrayList;

public class InputLayer {

	
	private int numberOfNeuronsInLayer;
	private static ArrayList <Neuron> ListOfNeurons = new ArrayList <Neuron>();
	
	public InputLayer initLayer (InputLayer inputLayer){
		System.out.println("initiating InputLayer");
		numberOfNeuronsInLayer = 3;
		Layer layer = new Layer();
		int NumberOfWeightIn = 2;
		for (int i = 0; i < numberOfNeuronsInLayer; i ++){
			Neuron neuron = new Neuron();
			neuron.initNeuron(NumberOfWeightIn, 0, neuron);
			ListOfNeurons.add(neuron);
		}
		layer.setNumberOfNeuronsInLayer(numberOfNeuronsInLayer);
		layer.setListOfNeurons(ListOfNeurons);
		return inputLayer;	                                                                                          
	} 
	
	void printLayer(InputLayer inputLayer){
		System.out.println("------ InputLayer ------");
		int x = 1;
		for (int i = 0; i < numberOfNeuronsInLayer; i++){
			Neuron neuron = ListOfNeurons.get(i);
			System.out.println(x + ". Neuron");
			System.out.println("Input: ");
			System.out.println(neuron.getlistOfWeightIn());
			x++;
		}
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
