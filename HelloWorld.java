import lejos.nxt.Button;

public class HelloWorld {
	
	public static void main (String[] args) {
		SoundSensor sound = new SoundSensor(SensorPort.S1);
		int volume = sound.readValue();
		System.out.println("Volume: " + volume);
		Button.waitForAnyPress();
	}
	
}