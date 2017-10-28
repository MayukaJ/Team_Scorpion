import java.util.Random;

//import robocode.Robot;
import robocode.*;
//import robocode.ScannedRobotEvent;

import java.awt.*;



public class Scorpion extends BravoBot{
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
		while (getOthers()>3) {
			turnRight(40+randomNum.nextInt(20));
			ahead(5000);
		}
		while (getOthers()<4) {
			turnRight(50);
			ahead(5000);
			turnRight(60);
			ahead(5000);
		}
	}


	public void onScannedRobot(ScannedRobotEvent e) {
	   	if (e.getDistance() < 50 && getOthers()>6) {
           fire(5);
       } else if (e.getDistance() < 100 && getOthers()>4){
           fire(4);
       } else if (e.getDistance() < 200 && getOthers()>3){
           fire(3);
       } else if (e.getDistance() < 400){
           fire(2);
       } 
	}


	public void onHitByBullet(HitByBulletEvent e){
		double BHead=e.getHeading();
		if(getHeading()-BHead>-30 && getHeading()-BHead<30){
			turnRight(60);
			System.out.println("hit");
		}
	}
	

	public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() > -20 && e.getBearing() < 20) {
			fire(5);
			System.out.println("ram");
		}
		else if (e.getBearing() > 160 && e.getBearing() < -160) {
			fire(5);
			System.out.println("ram");
		}
		//ahead(10);
	
	}


	public void onHitWall(HitWallEvent e){
		double head=getHeading();
		turnRight(10);
		System.out.println("wall");
	}
	
}
