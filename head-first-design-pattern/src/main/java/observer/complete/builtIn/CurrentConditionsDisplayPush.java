package observer.complete.builtIn;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplayPush implements Observer, DisplayElement {

  private float temperature;
  private float humidity;

  public CurrentConditionsDisplayPush(Observable weatherData) {
    weatherData.addObserver(this);
  }

  @Override
  public void update(Observable o, Object arg) {

    if (arg instanceof Data) {
      Data data = (Data) arg;
      this.temperature = data.getTemp();
      this.humidity = data.getHumidity();
      display();
    }

  }

  @Override
  public void display() {
    System.out
        .println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
  }

}
