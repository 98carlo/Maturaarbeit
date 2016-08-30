import java.util.ArrayList;

public class NeuralNet {
	
	private InputLayer inputLayer;
	private HiddenLayer hiddenLayer;
	private ArrayList <HiddenLayer> listOfHiddenLayer = new ArrayList <HiddenLayer>();
	private OutputLayer outputLayer;
	//private int numberOfHiddenLayers;
	private int maxEpochs;
	//2 dimensional trainSet
	//one dimension are the coordinates
	private double[] [] trainSet;
	private double learningRate;
	private double [] estimatedOutputData;
	private double targetError;
	private double trainingError;
	/*
	private Training.Train ingTypesENUM trainType;
	private Training.ActivationFncENUM activationFnc;
	private ArrayList <Double> listOfMSE = new ArrayList<Double>();*/
	
	


	public static void main(String [ ] args) throws Exception {
		System.out.println("initiating Neural Network");
		NeuralNet n = new NeuralNet();
		n.initNet();
		n.printNet();
		//System.out.println("starting Emulator");
		//EmulatorStart emulator = new EmulatorStart();
		//emulator.startEmulator();

	}
	
	public void initNet(){
		inputLayer = new InputLayer();
		inputLayer = inputLayer.initLayer(inputLayer);
		outputLayer = new OutputLayer();
		outputLayer = outputLayer.initLayer(outputLayer);
		/*numberOfHiddenLayers = 2;
		for (int i = 0; i < numberOfHiddenLayers; i++){
		hiddenLayer = new HiddenLayer();
		listOfHiddenLayer = hiddenLayer.initLayer(hiddenLayer, listOfHiddenLayer, inputLayer, outputLayer);
		}*/

	}
	
	public void printNet(){
		
		inputLayer.printLayer(inputLayer);
		for(int i = 0; i < listOfHiddenLayer.size(); i++){
			hiddenLayer = listOfHiddenLayer.get(i);
			int x = i + 1;
			System.out.println("------ " + x +". HiddenLayer ------");
			hiddenLayer.printLayer(hiddenLayer);
		}
		outputLayer.printLayer(outputLayer);
	
	}
	
	public void setTrainSet (double [][] trainSet){
		this.trainSet = trainSet;
		
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
	
	public HiddenLayer getHiddenLayer (NeuralNet n, int NumberOfHiddenLayer){
		
		hiddenLayer = listOfHiddenLayer.get(NumberOfHiddenLayer);
		
		return hiddenLayer;
	}
	
	public double [] getEstimatedOutputData(){
		return this.estimatedOutputData;
	}
	
	public void setEstimatedOutputData(double[]estimatedOutputData){
		this.estimatedOutputData = estimatedOutputData;
	}
	
	public double getTargetError (){
		return this.targetError;
	}

	
	public void setTargetError(double targetError){
		this.targetError = targetError;
	}
	
	public double getTrainingError(){
		return this.trainingError;
	}
	
	public void setTrainingError(double trainingError){
		this.trainingError = trainingError;
	}
	
	
	
	
	
	
}
