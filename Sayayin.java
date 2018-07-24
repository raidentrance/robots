package com.walmart.saya;
import robocode.*;
import robocode.control.events.BattleStartedEvent;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Sayayin - a robot by (your name here)
 */
public class Sayayin extends Robot
{
	
	private Saya sayayin;
	/**
	 * run: Sayayin's default behavior
	 */

	public void run() {
		double height= getBattleFieldHeight();
		// Initialization of the robot should be put here
		sayayin = new Saya(getX(), getY(), getHeading(), getGunHeading());
		
		if(sayayin.angulo<=181){
			turnRight(-sayayin.angulo);
		}else{
			turnLeft(sayayin.angulo);
		}

		if(sayayin.positionY <= height/2){
			back(sayayin.positionY - 3);
			sayayin.pos = 2;
		} else {
			ahead(sayayin.positionY + 3);
			turnRight(180);
			sayayin.pos = 1;
		}
		turnGunRight(45);
		sayayin.arma=getGunHeading();
		
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		
		while(true) {
	/*	switch (sayayin.pos){
		
			case 1: 
			break;
			
			case 2:
			break;*/
			
			if(sayayin.arma >=0){
				turnGunLeft(1);
			}
			if(sayayin.arma <=315){
				turnGunLeft(1);
			}
			sayayin.arma=getGunHeading();
			
		}
	
	}


	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(4);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
		fire(4);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
	

	
public class Saya{
	
public double positionX;
public double positionY;
public double angulo;
public double arma;
public int pos;

 public Saya(double positionX, double positionY, double angulo, double arma){
	 this.positionX = positionX;
	 this.positionY = positionY;
	 this.angulo = angulo; 
	 this.arma = arma;
 }


}
}


