import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Player {
		
	private static Robot robot = null;
	private int PlayerID;
	
	public void setPlayerID (int PlayerID){
		
		this.PlayerID = PlayerID;
		
	}
	
	public int getPlayerID (){
		
		return this.PlayerID;
		
	}
	
	public void Moves (int PlayerID, int Move) throws Exception{
		robot = new Robot();
		switch(PlayerID){
		//Shang Tsung
		case 1:
			switch(Move){
				case 1: KeyPress (KeyEvent.VK_UP);
					break;
				case 2: KeyPress (KeyEvent.VK_DOWN);
					break;
				case 3: KeyPress (KeyEvent.VK_RIGHT);
					break;
				case 4: KeyPress (KeyEvent.VK_LEFT);
					break;
				case 5: KeyPress (KeyEvent.VK_C);
					break;
				case 6: KeyPress (KeyEvent.VK_V);
					break;
				case 7: KeyPress (KeyEvent.VK_X);
					break;
				case 8: KeyPress (KeyEvent.VK_D);
					break;
				case 9: KeyPress (KeyEvent.VK_A);
					break;
				case 10: KeyPress (KeyEvent.VK_S);
					break;
				case 11: KeyPress (KeyEvent.VK_N);
					break;
				case 12: KeyPress (KeyEvent.VK_M);
					break;
				case 13: KeyPress (KeyEvent.VK_B);
					break;
				case 14: KeyPress (KeyEvent.VK_Q);
					break;
				case 15: KeyPress (KeyEvent.VK_RIGHT);
						 robot.delay(50);
						 KeyPress (KeyEvent.VK_LEFT);
						 robot.delay(50);
						 KeyCombination(KeyEvent.VK_LEFT, KeyEvent.VK_V);
					break;
				case 16: KeyPress (KeyEvent.VK_LEFT);
						 robot.delay(50);
						 KeyCombination(KeyEvent.VK_LEFT,KeyEvent.VK_X);
					break;
				case 17: KeyPress (KeyEvent.VK_LEFT);
						 robot.delay(50);
						 KeyPress (KeyEvent.VK_LEFT);
						 robot.delay(50);
						 KeyCombination(KeyEvent.VK_RIGHT, KeyEvent.VK_X);
					break;
				case 18: KeyPress (KeyEvent.VK_LEFT);
						 robot.delay(50);
						 KeyPress (KeyEvent.VK_LEFT);
						 robot.delay(50);
						 KeyPress (KeyEvent.VK_RIGHT);
						 robot.delay(50);
						 KeyCombination(KeyEvent.VK_RIGHT, KeyEvent.VK_X);
					break;
				default: System.out.println("invalid move");
					break;
						 
				
			}
		
		}
		
	}
	
	private void KeyPress (int Key){
		
		robot.keyPress(Key);
        robot.delay(50);
        robot.keyRelease(Key);
        robot.delay(50);
	
	}
	
	public static void KeyCombination (int k, int l)
    {
        robot.keyPress(k);
        robot.delay(10);
        robot.keyPress(l);
        robot.keyRelease(l);
        robot.keyRelease(k);
        robot.delay(100);
    }
  

}
