import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class MatchTemplate {
	static final String filepath = "C:\\Users\\carlo\\Desktop\\Maturaarbeit\\Screenshots\\";
	public static void main(String[] args) throws Exception {
		//importing library and images
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		//new matching().run(filepath + "result.jpg", filepath + "Shang_dilate.jpg", filepath + "result.jpg", Imgproc.TM_CCOEFF);
		new difference().run(filepath + "scr.jpg", filepath + "scr - Copy.jpg", filepath + "1234.jpg");
	}
}	

class matching
{
	public void run(String inFile, String templateFile, String outFile, int match_method)
	{
		System.out.println(inFile);
		Mat image = Imgcodecs.imread(inFile);
		Mat templ = Imgcodecs.imread(templateFile);
		//creating result Matrix
		int result_cols = image.cols() - templ.cols() + 1;
        int result_rows = image.rows() - templ.rows() + 1;
        Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
        //do the matching
        Imgproc.matchTemplate(image, templ, result, match_method);
        //look for the best match in the picture
        MinMaxLocResult mmr = Core.minMaxLoc(result);

        Point matchLoc;
        if (match_method == Imgproc.TM_SQDIFF || match_method == Imgproc.TM_SQDIFF_NORMED) {
            matchLoc = mmr.minLoc;
        } else {
            matchLoc = mmr.maxLoc;
        }
        //show me what you got with a rectangle and save it into scr.jpg
        Imgproc.rectangle(image, matchLoc, new Point(matchLoc.x + templ.cols(), 
                matchLoc.y + templ.rows()), new Scalar(255, 0, 0));

        System.out.println("Writing "+ outFile);
        Imgcodecs.imwrite(outFile, image);
	}

}

class difference
{
	public Mat run(String background, String inFile, String outFile){
		Mat model = Imgcodecs.imread(background, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
		Mat scene = Imgcodecs.imread(inFile, Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
		Mat diff = new Mat();
        Core.absdiff(model,scene,diff);
        Imgproc.threshold(diff,diff,15,255,Imgproc.THRESH_BINARY);
        int distortion = Core.countNonZero(diff);
        System.out.println(diff);
        Imgcodecs.imwrite(outFile ,diff);
        return diff;
        
	}
}

class morphology
{
	public void run(String img){
		Mat image = Imgcodecs.imread(img);
		int result_cols = image.cols();
		int result_rows = image.rows();
		
		Mat result = new Mat (result_rows, result_cols, Imgcodecs.CV_LOAD_IMAGE_COLOR);
		
		result = image;
		
		int erosion_size = 5;
		
		Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*erosion_size + 1, 2*erosion_size+1));
		
		Imgproc.erode(image, result, element);
		Imgcodecs.imwrite(img, result);
		}
}

@SuppressWarnings("serial")
class KeyListen extends JFrame implements KeyListener
{
		private Boolean esc = false;
		private static Robot robot = null;
	public void run() throws Exception {
		new KeyListen();
	}
		
		JLabel label;

	public KeyListen() throws Exception{
		robot = new Robot();
		JPanel p = new JPanel();
        label = new JLabel("Key Listener!");
        p.add(label);
        add(p);
        addKeyListener( (java.awt.event.KeyListener) this);
        setSize(1, 1);
        setVisible(true);
        robot.delay(35);
        setVisible(false);
        robot.mouseMove(500, 500);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);
        robot.delay(10);
	}
	
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			esc = true;
		}
		
	}

	public void keyReleased(KeyEvent e) {
		
		
	}

	public void keyTyped(KeyEvent e) {
		
		
	}
	
	public Boolean escapeKeyPressed(){
		return this.esc;
	}
}

