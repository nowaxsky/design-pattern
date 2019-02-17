package observer.complete.builtIn;

public class PullDemo {

  public static void main(String[] args) {
    WeatherDataPull weatherData = new WeatherDataPull();
    CurrentConditionsDisplayPull currentConditionsDisplay = new CurrentConditionsDisplayPull(weatherData);
    StatisticsDisplayPull statisticsDisplay = new StatisticsDisplayPull(weatherData);
    ForecastDisplayPull forecastDisplay = new ForecastDisplayPull(weatherData);
    
    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.2f);
  }

}
