import java.util.ArrayList;

public class OutputLayer {
	 
	private ArrayList <Neuron> ListOfNeurons = new ArrayList <Neuron> ();
	private int NumberOfNeuronsInLayer;
	
	public OutputLayer initLayer (OutputLayer outputLayer){
		Layer layer = new Layer();
		int NumberOfWeightOut = 2;
		for (int i = 0; i < NumberOfNeuronsInLayer; i ++){
			Neuron neuron = new Neuron();
			neuron.initNeuron(0, NumberOfWeightOut, neuron);
			ListOfNeurons.add(neuron);
		}
		layer.setListOfNeurons(ListOfNeurons);
		return outputLayer;
	}
	
	public void printLayer (OutputLayer outputLayer){
		System.out.println("----OutputLayer----");
		System.out.println(outputLayer.toString());
	}
	
	public void setNumberOfNeuronsInLayer (int numberOfNeuronsInLayer){
		NumberOfNeuronsInLayer = numberOfNeuronsInLayer;
		ListOfNeurons.ensureCapacity(NumberOfNeuronsInLayer);
	}

	public int getNumberOfNeuronsInLayer() {
		return this.NumberOfNeuronsInLayer;
	}

}