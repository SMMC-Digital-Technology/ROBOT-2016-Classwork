import lejos.nxt.*;
import lejos.util.*;

/**
 * A robot that acts like a scared mouse.
 *
 * @author	Mr Burt
 * @version	0.1
 */

public class Mousebot {
	
	/**
	 * declare variables here
	 */
	private SoundSensor soundSensor;
	
	/**
	 * Constructs the robot and sets up the sensors and initial values of variables
	 */
	public Mousebot () {
		// setup values
		soundSensor = new SoundSensor(SensorPort.S2);
		
		run();
	}
	
	/**
	 * This is where the robot does something
	 */
	private void run() {
		// set motor speed
		int soundLevel = soundSensor.readValue();
		Motor.A.setSpeed(soundLevel*36);
		Motor.C.setSpeed(soundLevel*36);
		
		// move forward for 6 seconds
		Motor.A.forward();
		Motor.C.forward();
		Delay.msDelay(6000);
		// spin for 2 seconds
		Motor.C.backward();
		Delay.msDelay(2000);
		// stop
		Motor.A.stop();
		Motor.C.stop();
		
		// wait to end program
		Button.waitForAnyPress();
	}
	
	/**
	 * The main function executes the robot.
	 * @param args Not used.
	 */
	public static void main (String[] args) {
		new Mousebot();
	}
}