package walm.coding.dojo;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Yoshimi - a robot by (your name here)
 */
public class Yoshimi extends Robot
{
	/**
	 * run: Yoshimi's default behavior
	 */
	private boolean isMoving=true;
	
	public void run() {
		// Initialization of the robot should be put here
		out.println("Stating");
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
			//Starting conditions
			setBodyColor(Color.MAGENTA);
			setBulletColor(Color.CYAN);
			//if (getHeading() >180) { 
			turnRight( (180 - getHeading() ) );
			//} else {
				//turnLeft( (180 + getHeading() ) );
			//}
			
			//out.println(getHeight());

		// Robot main loop
		while(true) {
			if (isMoving) {
				ahead(100); 
				
			}
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		//fire(1);
		//turnGunRight(360);
		//turnLeft(90);
		//ahead(50);
		//turnRight(90);
		
		//turnGunRight(e.getBearing());
		//fire(2);
		fireBullet(Rules.MAX_BULLET_POWER);
	
		
	}
	
	public float getAngle(double targetX, double targetY) {
	    return (float) Math.toDegrees(Math.atan2(targetX - getX(), targetY - getY()));
	}
	


	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(90);
		ahead(100);
		turnLeft(90);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		turnLeft(90);
		
	}	
}
