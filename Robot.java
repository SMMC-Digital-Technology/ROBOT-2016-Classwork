import lejos.nxt.*;
import lejos.util.*;

/**
 * Standard file for LeJOS robots
 * Change every "Robot" below with the name of your program. eg "WallFinder"
 * Save the file with the same name. eg "WallFinder.java"
 *
 * @author	Mr Burt
 * @version	0.1
 */

public class Robot {
	
	/**
	 * declare variables here
	 */
	// examples:
	// private TouchSensor sensorLeft;
	// private int code = 1234;
	
	/**
	 * Constructs the robot and sets up the sensors and initial values of variables
	 */
	public Robot () {
		// setup sensors
		// sensorLeft = new TouchSensor(SensorPort.S1);
		
		
		// setup values
		
		
		run();
	}
	
	/**
	 * This is where the robot does something
	 */
	private void run() {
		// put in code here
	}
	
	/**
	 * The main function executes the robot.
	 * @param args Not used.
	 */
	public static void main (String[] args) {
		new Robot();
	}
}