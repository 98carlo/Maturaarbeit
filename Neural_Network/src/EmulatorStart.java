
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

import org.opencv.core.Core;
import org.opencv.core.Mat;


public class EmulatorStart {
	static final String filepath = "C:\\Users\\carlo\\Desktop\\Maturaarbeit\\Screenshots\\";

	private static Robot robot = null;
	public static void main(String[] args) throws Exception{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		int m = 0;
		int i = 1;
		startEmulator();
		Boolean esc = false;
		//new morphology().run(filepath + "scr0.jpg");
		while(esc == false){
			String background = filepath + "scr" + m + ".jpg";
			String inFile = filepath + "scr" + i + ".jpg";
			new KeyListen().run();
			Screenshot(inFile);
			//new morphology().run(inFile);
			String diff = filepath + i + ".jpg";
			Mat matDiff = new difference().run(background, inFile, diff);
			m++;
			i++;
			esc = new KeyListen().escapeKeyPressed();
		}
		System.exit(0);
	}
    
    public static void startEmulator() throws Exception{
    	   	
        robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width2 = screenSize.getWidth();
		int width = (int) width2;
		double height2 = screenSize.getHeight();
		int height = (int) height2;
		klick (width-(width/15),20);
		robot.delay(100);
		startEmulator(width,height);
        doubleklick (width-(width/15),80);
        Keycombination(KeyEvent.VK_ALT,KeyEvent.VK_ENTER);
        robot.delay(23000);
        doubleklick(width/2,height/2);
        robot.delay(1000);
        PressKey(KeyEvent.VK_SPACE);
        robot.delay(2000);
        PressKey(KeyEvent.VK_SPACE);
        //System.out.println("enter clicked");
        robot.delay(5000);
        PressKey(KeyEvent.VK_C);
        robot.delay(6000);
        PressKey(KeyEvent.VK_C);
        robot.delay(7000);
        PressKey(KeyEvent.VK_SPACE);
        robot.delay(5500);
        //taking a screenshot and saving it to the desktop
        Screenshot(filepath + "scr0.jpg");
        
    }
   
    
    public static void klick (int x, int y)
    {
        robot.mouseMove(x, y);
        robot.delay(100);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);
        robot.delay(100);
    }
    
    public static void doubleklick (int x, int y)
    {
        robot.mouseMove(x, y);
        robot.delay(100);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);
        robot.delay(10);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);
        robot.delay(1000);
    }
    
    public static void PressKey (int k)
    {
        robot.keyPress(k);
        robot.delay(50);
        robot.keyRelease(k);
        robot.delay(50);
    }
    
    public static void Keycombination (int k, int l)
    {
        robot.keyPress(k);
        robot.delay(10);
        robot.keyPress(l);
        robot.keyRelease(l);
        robot.keyRelease(k);
        robot.delay(1000);
    }
  
    public static void writeMK3 ()
    {
    	PressKey (KeyEvent.VK_M);
    	PressKey (KeyEvent.VK_O);
    	PressKey (KeyEvent.VK_R);
    	PressKey (KeyEvent.VK_T);
    	PressKey (KeyEvent.VK_A);
    	PressKey (KeyEvent.VK_L);
    	PressKey (KeyEvent.VK_SPACE);
    	PressKey (KeyEvent.VK_K);
    	PressKey (KeyEvent.VK_O);
    	PressKey (KeyEvent.VK_M);
    	PressKey (KeyEvent.VK_B);
    	PressKey (KeyEvent.VK_A);
    	PressKey (KeyEvent.VK_T);
    	PressKey (KeyEvent.VK_SPACE);
    	PressKey (KeyEvent.VK_3);
    	PressKey (KeyEvent.VK_SPACE);
    	Keycombination (KeyEvent.VK_SHIFT, KeyEvent.VK_8);
    	PressKey (KeyEvent.VK_E);
    	PressKey (KeyEvent.VK_U);
    	PressKey (KeyEvent.VK_R);
    	PressKey (KeyEvent.VK_O);
    	PressKey (KeyEvent.VK_P);
    	PressKey (KeyEvent.VK_E);
    	Keycombination (KeyEvent.VK_SHIFT, KeyEvent.VK_9);
    	PressKey (KeyEvent.VK_PERIOD);
    	PressKey (KeyEvent.VK_Z);
    	PressKey (KeyEvent.VK_I);
    	PressKey (KeyEvent.VK_P);
    }
    
    public static void /*BufferedImage*/ Screenshot (String source) throws Exception
    {
        //getting the screensize
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        //making a rectangle which fills the whole screen
        //need to get the screenSize again because otherwise it makes the screenshot a lot smaller
        Rectangle screenRect = new Rectangle(screenSize);
        //making a screenshot and saving it to the desktop
        BufferedImage image;
        image = robot.createScreenCapture(screenRect);
        File file = new File(source);
        if(!file.exists())
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        ImageIO.write( image, "jpg", fos );
        robot.delay(100);
        //return image;       
    }
    
    public static void startEmulator (int width, int height) throws Exception
    {
    	//starting the Emulator
    	Process p = Runtime.getRuntime().exec("C:\\Users\\carlo\\Desktop\\Maturaarbeit\\Emulator MA\\snes9x.exe");   	
    	//opening the ROM
    	robot.delay(1000);
    	doubleklick (width-(width/15),90);
    	robot.delay(1000);
    	Keycombination(KeyEvent.VK_CONTROL,KeyEvent.VK_O);
    	robot.delay(1000);
    	writeMK3();
    	PressKey (KeyEvent.VK_ENTER);
    }
       
    
    
    
    
    
}
