package observer.complete;

public class MyDisplay implements Observer2, DisplayElement2 {

  private Subject2 weatherData;
  private float temp;
  private float humidity;
  private float pressure;

  public MyDisplay(Subject2 weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void display(Subject2 subject) {
    System.out.println("Raw data as following: 1. temp = " + temp + ", humidity = " + humidity
        + ", pressure = " + pressure);
  }

  @Override
  public void update(Subject2 subject, Object arg) {
    if (subject instanceof WeatherData2) {
      WeatherRawData data = (WeatherRawData) arg;
      this.temp = data.getTemp();
      this.humidity = data.getHumidity();
      this.pressure = data.getPressure();
      display(subject);
    }
  }

}
