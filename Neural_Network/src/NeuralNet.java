import java.util.ArrayList;

public class NeuralNet {
	
	private InputLayer inputLayer;
	private HiddenLayer hiddenLayer;
	private ArrayList <HiddenLayer> listOfHiddenLayer;
	private OutputLayer outputLayer;
	private int numberOfHiddenLayers;
	private int maxEpochs;
	private double[] [] trainSet;
	private double learningRate;
	/*
	private double [] realOutputSet;
	private double targetError;
	private double trainingsError;
	private Training.TrainingTypesENUM trainType;
	private Training.ActivationFncENUM activationFnc;
	private ArrayList <Double> listOfMSE = new ArrayList<Double>();*/
	
	


	public static void main(String [ ] args) {
		System.out.println("hi");
		NeuralNet n = new NeuralNet();
		n.initNet();
		n.printNet();

	}
	
	public void initNet(){
		inputLayer = inputLayer.initLayer(inputLayer);
		listOfHiddenLayer = hiddenLayer.initLayer(hiddenLayer, listOfHiddenLayer, inputLayer, outputLayer);
		outputLayer = outputLayer.initLayer(outputLayer);
		
	}
	
	public void printNet(){
		
		inputLayer.printLayer(inputLayer);
		hiddenLayer.printLayer(listOfHiddenLayer);
		outputLayer.printLayer(outputLayer);
	
	}
	
	public double [] [] getTrainSet(){
		return this.trainSet;
	}
	
	public int getMaxEpochs(){
		return this.maxEpochs;
	}
	

	public void setMaxEpochs(int maxEpochs){
		this.maxEpochs = maxEpochs;
	}
	
	public InputLayer getInputLayer() {
		
		return this.inputLayer;
	}
	
	public OutputLayer getOutputLayer(){
		
		return this.outputLayer;
	}

	public void setInputLayer(InputLayer inputLayer) {
		
		
		
	}
	
	public void setLearningRate (double learningRate){
		
		this.learningRate = learningRate;
	
	}
	
	public double getLearningRate(){
		
		return this.learningRate;
	
	}
	
	/*public NeuralNet trainNet (NeuralNet n){
		return n;
	}
	
	public void setTargetError (double targetError){
		
	}
	
	public void printTrainedNetResult (NeuralNet n){
		
	}
	
	public double [] getRealOutputSet(){
		
	}
	
	public void setRealOutputSet(double [] realOutputSet){
		
	}
	
	public double getTargetError(){
		
	}
	
	public void setTrainingError (double trainingError){
		
	}
	
	public ActivationFncENUM getActivationFnc(){
		
	}
	
	public void setActivationFnc (ActivationFncENUM activationFnc){
		
	}

	public TrainingTypesENUM getTrainType(){
		
	}
	
	public void setTrainType(TrainingTypesENUM trainType){
		
	}
	
	public ArrayList <Double>getListOfMSE(){
		
	}
	
	public void setListOfMSE(ArrayList<Double> listOfMSE){
		
	}*/

	
	
}
