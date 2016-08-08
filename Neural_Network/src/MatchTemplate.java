import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class MatchTemplate {
	static final String filepath = "C:\\Users\\carlo\\Desktop\\Maturaarbeit\\Screenshots\\";
	public static void main(String[] args) throws Exception {
		//importing library and images
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		new matching().run(filepath + "scr.jpg", filepath + "Shang.jpg", filepath + "result.jpg", Imgproc.TM_CCOEFF);
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
                matchLoc.y + templ.rows()), new Scalar(0, 255, 0));

        System.out.println("Writing "+ outFile);
        Imgcodecs.imwrite(outFile, image);
	}

}