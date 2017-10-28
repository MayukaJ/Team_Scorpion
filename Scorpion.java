//import robocode.Robot;
import robocode.*;
//import robocode.ScannedRobotEvent;

import java.awt.*;

public class Scorpion extends AlphaBot{

	public void run() {
		// Set colors
		setBodyColor(Color.blue);
		setGunColor(Color.blue);
		setRadarColor(Color.black);
		setScanColor(Color.yellow);
	//	double FWidth=getBattleFieldWidth();
		double FHeight=getBattleFieldHeight();
		// Loop forever
		while (true) {
			// Tell the game that when we take move,
			// we'll also want to turn right... a lot.
			turnRight(90);
			ahead(500);
			turnRight(100);
			//ahead(400);
			if (getY()==(FHeight/2)){
				turnLeft(360);
			}
			// Limit our speed to 5
			// Start moving (and turning)
			ahead(1000);
		
			
			// Repeat.
		}
	}

	/**
	 * onScannedRobot: Fire hard!
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
	
		if (e.getDistance() < 50) {
           fire(5);
       } else if (e.getDistance() < 100){
           fire(4);
       } else if (e.getDistance() < 200){
           fire(3);
       } else if (e.getDistance() < 400){
           fire(2);
       } 
	}

	/**
	 * onHitRobot:  If it's our fault, we'll stop turning and moving,
	 * so we need to turn again to keep spinning.
	 */
	public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() > -10 && e.getBearing() < 10) {
			fire(3);
		}
		if (e.isMyFault()) {
			turnRight(10);
		}
	}
	
	public void onHitWall(HitWallEvent e) {
		double head=getHeading();
		turnRight(120-(head%90));		
	}
			
}
