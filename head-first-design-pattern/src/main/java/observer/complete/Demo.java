package observer.complete;

public class Demo {

  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();
    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
    
    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.2f);
    
    System.out.println("\n---remove Weather subject---\n");
    forecastDisplay.removeSubject();
    
    weatherData.setMeasurements(83, 55, 28.2f);
    weatherData.setMeasurements(87, 35, 30.0f);
    
    System.out.println("\n---add Weather subject---\n");
    forecastDisplay.addSubject();
    
    weatherData.setMeasurements(89, 40, 29.8f);
    weatherData.setMeasurements(82, 45, 30.2f);
    
  }

}
