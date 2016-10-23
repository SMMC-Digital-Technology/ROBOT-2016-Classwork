import lejos.nxt.*;
import lejos.util.*;

/**
 * Standard file for LeJOS robots
 * Change every "Ninja" below with the name of your program. eg "WallFinder"
 * Save the file with the same name. eg "WallFinder.java"
 *
 * @author	Mr Burt
 * @version	0.1
 */

public class Ninja {
	
	/**
	 * declare variables here
	 */
	private LightSensor light;
	
	private final int SETPOINT = 50;
	
	/**
	 * Constructs the robot and sets up the sensors and initial values of variables
	 */
	public Ninja () {
		light = new LightSensor(SensorPort.S1);		
		
		// turn the lamp off
		light.setFloodlight(false);
		run();
	}
	
	/**
	 * This is where the robot does something
	 */
	private void run() {
		Delay.msDelay(1000);
		while (!Button.ENTER.isDown()) {
			int level = light.getLightValue();
			if (level > SETPOINT) {
				Motor.A.stop();
				Motor.C.stop();
				shadowTurn(level);
			} else {
				Motor.A.forward();
				Motor.C.forward();
			}
		}
	}
	
	/**
	 * Turns the robot in the direction of more shadow.
	 * @param forwardLevel The amount of light in the forwards direction.
	 */
	private void shadowTurn(int forwardLevel) {
		Motor.A.rotate(30);
		int level = light.getLightValue();
		if (level < forwardLevel) {
			Motor.A.forward();
			Motor.C.backward();
		} else {
			Motor.A.backward();
			Motor.C.forward();
		}
	}
	
	/**
	 * The main function executes the robot.
	 * @param args Not used.
	 */
	public static void main (String[] args) {
		new Ninja();
	}
}