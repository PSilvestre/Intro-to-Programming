
public class Main {
	public static void main(String[] args) {
		WeatherStation w = new WeatherStation();
		
		System.out.println("num temps: " + w.numberTemperatures());
		w.sampleTemperature(10.0);
		System.out.println("minimum: " + w.getMinimum());
		w.sampleTemperature(12.0);
		w.sampleTemperature(-13.0);
		w.sampleTemperature(16.0);
		w.sampleTemperature(9.0);
		System.out.println(w.getMaximum());
		System.out.println(w.getMinimum());
		System.out.println(w.getAverage());
	}
}