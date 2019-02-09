package observer.complete.builtIn;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplayPull implements Observer, DisplayElement {

  private float temperature;
  private float humidity;

  public CurrentConditionsDisplayPull(Observable weatherData) {
    weatherData.addObserver(this);
  }

  @Override
  public void update(Observable o, Object arg) {
    if(o instanceof WeatherDataPull) {
      WeatherDataPull weatherData = (WeatherDataPull) o;
      this.temperature = weatherData.getTemp();
      this.humidity = weatherData.getHumidity();
      display();
    }
  }
  
  @Override
  public void display() {
    System.out
        .println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
  }

}
