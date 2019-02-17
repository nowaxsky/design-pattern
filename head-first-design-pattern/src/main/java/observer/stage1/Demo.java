package observer.stage1;

public class Demo {

  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();
    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.2f);
  }

}
