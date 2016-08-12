import java.util.ArrayList;

public class NeuralNet {
	
	private InputLayer inputLayer;
	private HiddenLayer hiddenLayer;
	private ArrayList <HiddenLayer> listOfHiddenLayer = new ArrayList <HiddenLayer>();
	private OutputLayer outputLayer;
	private int numberOfHiddenLayers;
	private int maxEpochs;
	//need 3 dimensional trainSet so I can describe the location of the players
	//which position and x-coordinates and y-coordinates
	private double[] [] trainSet;
	private double learningRate;
	/*
	private double [] realOutputSet;
	private double targetError;
	private double trainingsError;
	private Training.Train ingTypesENUM trainType;
	private Training.ActivationFncENUM activationFnc;
	private ArrayList <Double> listOfMSE = new ArrayList<Double>();*/
	
	


	public static void main(String [ ] args) throws Exception {
		System.out.println("initiating Neural Network");
		NeuralNet n = new NeuralNet();
		n.initNet();
		n.printNet();
		System.out.println("starting Emulator");
		EmulatorStart emulator = new EmulatorStart();
		emulator.startEmulator();

	}
	
	public void initNet(){
		inputLayer = new InputLayer();
		inputLayer = inputLayer.initLayer(inputLayer);
		outputLayer = new OutputLayer();
		outputLayer = outputLayer.initLayer(outputLayer);
		numberOfHiddenLayers = 1;
		for (int i = 0; i < numberOfHiddenLayers; i++){
		hiddenLayer = new HiddenLayer();
		listOfHiddenLayer = hiddenLayer.initLayer(hiddenLayer, listOfHiddenLayer, inputLayer, outputLayer);
		}

		
	}
	
	public void printNet(){
		
		inputLayer.printLayer(inputLayer);
		for(int i = 0; i < listOfHiddenLayer.size(); i++){
			hiddenLayer = listOfHiddenLayer.get(i);
			hiddenLayer.printLayer(hiddenLayer);
		}
		outputLayer.printLayer(outputLayer);
	
	}
	
	public void setTrainSet (){
		
		
	}
	
	public double [] []  getTrainSet(){
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
		
		this.inputLayer = inputLayer;
		
	}
	
	public void setLearningRate (double learningRate){
		
		this.learningRate = learningRate;
	
	}
	
	public double getLearningRate(){
		
		return this.learningRate;
	
	}
	
	public NeuralNet trainNet (NeuralNet n){
		Kohonen Training = new Kohonen();
		n = Training.train(n);
		return n;
	}
	
	/*
	
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
