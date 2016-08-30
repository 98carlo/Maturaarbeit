import java.util.ArrayList;

public class InputLayer {

	
	private int numberOfNeuronsInLayer;
	private static ArrayList <Neuron> ListOfNeurons = new ArrayList <Neuron>();
	
	public InputLayer initLayer (InputLayer inputLayer){
		System.out.println("initiating InputLayer");
		//Mortal Kombat 3 has a maximum of 19 scenarios, 10 basic moves, 7 special moves and 2 healthbars
		numberOfNeuronsInLayer = 19;
		Layer layer = new Layer();
		int NumberOfWeightIn = 2;
		int NumberOfWeightOut = 17;
		for (int i = 0; i < numberOfNeuronsInLayer; i ++){
			Neuron neuron = new Neuron();
			neuron.initNeuron(NumberOfWeightIn, NumberOfWeightOut, neuron);
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
			System.out.println("Output: ");
			System.out.println(neuron.getListOfWeightOut());
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
