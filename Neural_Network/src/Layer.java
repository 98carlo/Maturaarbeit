import java.util.ArrayList;

public class Layer {
	
	private static ArrayList <Neuron> listofNeurons;
	private int numberOfNeuronsInLayer;
	
	
	public ArrayList <Neuron> getListOfNeurons(){
		//Returns the Layer who was just processed
		return listofNeurons;	
	}
	
	public void setListOfNeurons(ArrayList<Neuron>listOfNeurons){
		//same thing as in the Neuron-class
		//ensures the Capacity by setting it equal to the numberOfNeuronsInLayer
		//then sets it equal to the parameter by replacing it with it
		listofNeurons.ensureCapacity(numberOfNeuronsInLayer);
		listofNeurons.addAll(0, listOfNeurons);
	}
	
	public int getNumberOfNeuronsInLayer(){
		//returns the number of the Neurons in the specified Layer
		return this.numberOfNeuronsInLayer;
	}
	
	public void setNumberOfNeuronsInLayer(int numberOfNeuronsInLayer){
		//sets the number Of Neurons equal to its parameters
		this.numberOfNeuronsInLayer = numberOfNeuronsInLayer;
		
	}

}
