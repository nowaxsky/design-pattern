package observer.complete.builtIn;

public class PushDemo {

  public static void main(String[] args) {
    WeatherDataPush weatherData = new WeatherDataPush();
    CurrentConditionsDisplayPush currentConditionsDisplay = new CurrentConditionsDisplayPush(weatherData);
    StatisticsDisplayPush statisticsDisplay = new StatisticsDisplayPush(weatherData);
    ForecastDisplayPush forecastDisplay = new ForecastDisplayPush(weatherData);
    
    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.2f);
  }

}
