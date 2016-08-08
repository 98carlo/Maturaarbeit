import java.util.ArrayList;

public class InputLayer {

	
	private int numberOfNeuronsInLayer;
	private static ArrayList <Neuron> ListOfNeurons;
	
	public InputLayer initLayer (InputLayer inputLayer){
		inputLayer = new InputLayer();
		ArrayList <Double> weightIn = new ArrayList <Double> ();
		for (int i = 0; i < numberOfNeuronsInLayer; i++){
			Neuron neuron = new Neuron();
			double WeightIn = neuron.initNeuron();
			weightIn.clear();
			weightIn.add(WeightIn);
			neuron.setListOfWeightIn(weightIn);
			ListOfNeurons.add(neuron);
		}
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
