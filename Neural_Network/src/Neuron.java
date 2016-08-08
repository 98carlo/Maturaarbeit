import java.util.ArrayList;

public class Neuron {
	
	private ArrayList <Double> ListofWeightIn;
	private ArrayList <Double> ListofWeightOut;

	
	public Double initNeuron()
	{
		Double randomnum = Math.random();
		ListofWeightIn.add(randomnum);
		ListofWeightOut.add(randomnum);
		return randomnum;
		
	}
	
	public void setListOfWeightIn (ArrayList<Double>listOfWeightIn){
		//set the WeightsIn equal to the parameters
		//used to change the Weights
		//ensuring that the current ArrayList in the Neuron-class has a big enough Capacity
		ListofWeightIn.clear();
		ListofWeightIn.ensureCapacity(listOfWeightIn.size());
		ListofWeightIn.addAll(listOfWeightIn);
		
	}
	
	public void setListOfWeightOut(ArrayList <Double> listOfWeightOut){
		//set the WeightsOut equal to the parameters
		//used to change the Weights
		//ensuring that the current ArrayList in the Neuron-class has a big enough Capacity
		ListofWeightIn.clear();
		ListofWeightOut.ensureCapacity(listOfWeightOut.size());
		ListofWeightOut.addAll(listOfWeightOut);
		
	}
	
	public ArrayList<Double>getlistOfWeightIn(){
		//used for getting the current WeightsIn
		return ListofWeightIn;
	}
	
	public ArrayList<Double>getListOfWeightOut(){
		//used for getting the current WeightsOut
		return ListofWeightOut;
	}
	
}
