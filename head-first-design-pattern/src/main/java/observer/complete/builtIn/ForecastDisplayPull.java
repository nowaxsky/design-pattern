package observer.complete.builtIn;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplayPull implements Observer, DisplayElement {

  private float currentPressure = 29.92f;
  private float lastPressure;

  public ForecastDisplayPull(Observable observable) {
    observable.addObserver(this);
  }

  @Override
  public void update(Observable observable, Object arg) {
    if (observable instanceof WeatherDataPull) {
      WeatherDataPull weatherData = (WeatherDataPull) observable;
      lastPressure = currentPressure;
      currentPressure = weatherData.getPressure();
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
