
public class WeatherStation {
	
	private int numberTimesRegistered;
	
	private double averageTemp;
	private double highestTemp;
	private double lowestTemp;
	
	WeatherStation(){
		averageTemp = 0;
		highestTemp = 0;
		lowestTemp = 0;
	}
	
	public void sampleTemperature(double t) {
		numberTimesRegistered++;
		
		averageTemp = (averageTemp + t) / 2;
		
		if (t < lowestTemp)
			lowestTemp = t;
		if(t > highestTemp)
			highestTemp = t;
	}
	
	public int numberTemperatures(){
		return numberTimesRegistered;
	}
	
	public double getMaximum(){
		return highestTemp;
	}
	
	public double getMinimum(){
		return lowestTemp;
	}
	
	public double getAverage(){
		return averageTemp;
	}
	
}
