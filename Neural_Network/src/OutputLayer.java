import java.util.ArrayList;

public class OutputLayer {
	 
	private ArrayList <Neuron> ListOfNeurons = new ArrayList <Neuron> ();
	private int NumberOfNeuronsInLayer;
	
	public OutputLayer initLayer (OutputLayer outputLayer){
		System.out.println("initiating OutputLayer");
		Layer layer = new Layer();
		NumberOfNeuronsInLayer = 17;
		int NumberOfWeightOut = 1;
		for (int i = 0; i < NumberOfNeuronsInLayer; i ++){
			Neuron neuron = new Neuron();
			neuron.initNeuron(0, NumberOfWeightOut, neuron);
			ListOfNeurons.add(neuron);
		}
		layer.setNumberOfNeuronsInLayer(NumberOfNeuronsInLayer);
		layer.setListOfNeurons(ListOfNeurons);
		return outputLayer;
	}
	
	public void printLayer (OutputLayer outputLayer){
		System.out.println("----OutputLayer----");
		int x = 1;
		for (int i = 0; i < NumberOfNeuronsInLayer; i++){
			Neuron neuron = ListOfNeurons.get(i);
			System.out.println(x + ". Neuron");
			System.out.println("Output: ");
			System.out.println(neuron.getListOfWeightOut());
			x++;
		}
	}
	
	public void setNumberOfNeuronsInLayer (int numberOfNeuronsInLayer){
		NumberOfNeuronsInLayer = numberOfNeuronsInLayer;
		ListOfNeurons.ensureCapacity(NumberOfNeuronsInLayer);
	}

	public int getNumberOfNeuronsInLayer() {
		return this.NumberOfNeuronsInLayer;
	}

}