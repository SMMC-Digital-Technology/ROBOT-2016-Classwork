import lejos.nxt.*;
import lejos.util.*;

/**
 * A robot that moves forward when objects are far away, but turns randomly when they are close.
 *
 * @author	Mr Burt
 * @version	0.1
 */

public class BBot {
	
	/**
	 * declare variables here
	 */
	 /** Distance at which the robot turns. */
	private final int CLOSE = 10;
	
	private UltrasonicSensor uSonic;
	
	/**
	 * Constructs the robot and sets up the sensors and initial values of variables
	 */
	public BBot () {
		uSonic = new UltrasonicSensor(SensorPort.S4);		
		
		run();
	}
	
	/**
	 * This is where the robot does something
	 */
	private void run() {
		while (true) {
			int distance = uSonic.getDistance();
			if (distance < CLOSE) {
				// stop
				Motor.A.stop();
				Motor.C.stop();
				// turn
				Motor.A.forward();
				Motor.C.backward();
				Delay.msDelay((long) (Math.random()*1000));
				
			} else {
				// forward
				Motor.A.forward();
				Motor.C.forward();
			}
		}
	}
	
	/**
	 * The main function executes the robot.
	 * @param args Not used.
	 */
	public static void main (String[] args) {
		new BBot();
	}
}