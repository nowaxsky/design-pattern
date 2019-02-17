package observer.complete.builtIn;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplayPush implements Observer, DisplayElement {

  private float currentPressure = 29.92f;
  private float lastPressure;

  public ForecastDisplayPush(Observable observable) {
    observable.addObserver(this);
  }

  @Override
  public void update(Observable observable, Object arg) {
    if (arg instanceof Data) {
      Data data = (Data) arg;
      lastPressure = currentPressure;
      currentPressure = data.getPressure();
      display();
    }
  }

  @Override
  public void display() {
    System.out.print("Forecast: ");
    if (currentPressure > lastPressure) {
      System.out.println("Improving weather on the way!");
    } else if (currentPressure == lastPressure) {
      System.out.println("More of the same");
    } else if (currentPressure < lastPressure) {
      System.out.println("Watch out for cooler, rainy weather");
    }
  }
}
