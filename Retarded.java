package com.walmart;
import robocode.HitRobotEvent;
import robocode.HitByBulletEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;

import java.util.concurrent.TimeUnit;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Retarded - a robot by (your name here)
 */
public class Retarded extends Robot
{

	boolean peek; // Don't turn if there's a robot there
	double moveAmount; // How much to move
	int fires =1;

	/**
	 * run: Move around the walls
	 */
	public void run() {
		// Set colors
		setBodyColor(Color.black);
		setGunColor(Color.black);
		setRadarColor(Color.red);
		setBulletColor(Color.red);
		setScanColor(Color.cyan);
		for  ( int i = 0 ; i < 10; i++)
		{ 
				doNothing();
		}
		// Initialize moveAmount to the maximum possible for this battlefield.
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());

		
		out.println("Field width: " + getBattleFieldWidth());
		out.println("Field height: " + getBattleFieldHeight());
		
		// Initialize peek to false
		peek = false;

		// turnLeft to face a wall.
		// getHeading() % 90 means the remainder of
		// getHeading() divided by 90.
		turnLeft(getHeading() % 90);
		ahead(moveAmount);
		// Turn the gun to turn right 90 degrees.
		peek = true;
		turnGunRight(90);
		turnRight(90);

		while (true) {
			// Look before we turn when ahead() completes.
			peek = true;
			// Move up the wall
			out.println("x: " + getX());		
			out.println("y: " + getY());
			if(getX() >= 770.00 && getY() >= 570.00){
				moveAmount = 545;
			}
			if(getX() >= 770.00 && getY() <= 48.00){
				moveAmount = 752;
			}
			if(getX() <= 48.00 && getY() <= 48.00){
				moveAmount = 545;
			}
			if(getX() <= 48.00 && getY() >= 570.00){
				moveAmount = 752;
			}				
		    out.println("moveAmount: " + moveAmount);
			ahead(moveAmount);
			// Don't look now
			peek = false;
			// Turn to the next wall
			turnGunLeft(15);
			turnRight(90);
			turnGunRight(15);
			
			fires=1;
		}
	}
	


	/**
	 * onHitRobot:  Move away a bit.
	 */
	public void onHitRobot(HitRobotEvent e) {
		System.out.println("onHitRobot");
		// If he's in front of us, set back up a bit.
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			back(100);
		} // else he's in back of us, so set ahead a bit.
		else {
			ahead(100);
		}
	}

	/**
	 * onScannedRobot:  Fire!
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		fires=fires+2;
		out.println("onScannedRobot");
		fire(fires);
		// Note that scan is called automatically when the robot is moving.
		// By calling it manually here, we make sure we generate another scan event if there's a robot on the next
		// wall, so that we do not start moving up it until it's gone.
		if (peek) {
			scan();
			out.println("Fires: " + fires);
		}
	}
}
