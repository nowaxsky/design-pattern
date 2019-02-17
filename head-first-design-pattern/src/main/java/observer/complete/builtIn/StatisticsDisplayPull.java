package observer.complete.builtIn;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplayPull implements Observer, DisplayElement {

  private float maxTemp = 0.0f;
  private float minTemp = 200;
  private float tempSum = 0.0f;
  private int numReadings;

  public StatisticsDisplayPull(Observable observable) {
    observable.addObserver(this);
  }

  @Override
  public void update(Observable observable, Object arg) {
    if (observable instanceof WeatherDataPull) {
      WeatherDataPull weatherData = (WeatherDataPull) observable;
      float temp = weatherData.getTemp();
      tempSum += temp;
      numReadings++;

      if (temp > maxTemp) {
        maxTemp = temp;
      }

      if (temp < minTemp) {
        minTemp = temp;
      }

      display();
    }
  }

  @Override
  public void display() {
    System.out.println(
        "Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
  }
}
