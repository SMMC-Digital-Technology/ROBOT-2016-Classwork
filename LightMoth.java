import lejos.nxt.*;
import lejos.util.*;

/**
 * A robot that moves towards the brightest object in the room
 *
 * @author	Mr Burt
 * @version	0.1
 */

public class LightMoth {
	
	/**
	 * declare variables here
	 */
	private LightSensor light;
	
	/**
	 * Constructs the robot and sets up the sensors and initial values of variables
	 */
	public LightMoth () {
		light = new LightSensor(SensorPort.S1);
		
		
		run();
	}
	
	/**
	 * This is where the robot does something
	 */
	private void run() {
		// find the brightest object
		Motor.A.forward();
		Motor.C.backward();
		
		boolean keepSearching = true;
		int brightest = light.getLightValue() + 5;
		while (keepSearching) {
			int level = light.getLightValue();
			if (level > brightest) {
				brightest = level;
			} else if (level == brightest) {
				keepSearching = false;
				Motor.A.stop();
				Motor.C.stop();
			}
		}
		Motor.A.forward();
		Motor.C.forward();
		
		Button.waitForAnyPress();
	}
	
	/**
	 * The main function executes the robot.
	 * @param args Not used.
	 */
	public static void main (String[] args) {
		new LightMoth();
	}
}