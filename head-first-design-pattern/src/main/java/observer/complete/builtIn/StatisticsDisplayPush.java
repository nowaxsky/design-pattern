package observer.complete.builtIn;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplayPush implements Observer, DisplayElement {

  private float maxTemp = 0.0f;
  private float minTemp = 200;
  private float tempSum = 0.0f;
  private int numReadings;

  public StatisticsDisplayPush(Observable observable) {
    observable.addObserver(this);
  }

  @Override
  public void update(Observable observable, Object arg) {
    if (arg instanceof Data) {
      Data data = (Data) arg;
      float temp = data.getTemp();
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
