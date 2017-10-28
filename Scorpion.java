import java.util.Random;

//import robocode.Robot;
import robocode.*;
//import robocode.ScannedRobotEvent;

import java.awt.*;



public class Scorpion2 extends CharlieBot{
	Random randomNum=new Random();

	public void run() {
		// Set colors
		setBodyColor(Color.white);
		setGunColor(Color.blue);
		setRadarColor(Color.black);
		setScanColor(Color.yellow);
	//	double FWidth=getBattleFieldWidth();
		double FHeight=getBattleFieldHeight();
		// Loop forever
		while (true) {
			turnRight(10+randomNum.nextInt(10));
			ahead(5000);
		}
	}


	public void onRobotDetected(ScannedRobotEvent e) {
	   	if (e.getDistance() < 50 && getOthers()>5) {
           fire(2);
       } else if (e.getDistance() < 100 && getOthers()>3){
           fire(1);
       } else if (e.getDistance() < 200 && getOthers()>3){
           fire(1);
       } else if (e.getDistance() < 400){
           fire(1);
       } 
	}


	public void onHitByBullet(HitByBulletEvent e){
		double BHead=e.getHeading();
		if(getHeading()-BHead>-25 && getHeading()-BHead<25){
			turnRight(5);
			System.out.println("hit");
		}
	}
	

	public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() > -10 && e.getBearing() < 10) {
			fire(2);
			System.out.println("abc");
		}
	
	}


	public void onHitWall(HitWallEvent e){
		double head=getHeading();
		//turnRight(10);
	}
	
}
