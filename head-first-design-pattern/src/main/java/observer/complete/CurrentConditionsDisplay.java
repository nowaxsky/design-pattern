package observer.complete;

import java.util.ArrayList;
import java.util.List;

public class CurrentConditionsDisplay implements Observer2, DisplayElement2 {

  private List<Subject2> subjects;
  private float temperature;
  private float humidity;
  private float price;

  public CurrentConditionsDisplay(Subject2 subject) {
    subjects = new ArrayList<>();
    subjects.add(subject);
    subject.registerObserver(this);
  }

  public void addSubject(Subject2 subject) {
    subject.registerObserver(this);
  }

  public void removeSubject(Subject2 subject) {
    int i = subjects.indexOf(subject);
    if (i >= 0)
      subject.removeObserver(this);

  }

  @Override
  public void update(Subject2 subject, Object arg) {
    if (subject instanceof WeatherData2) {
      WeatherRawData data = (WeatherRawData) arg;
      this.temperature = data.getTemp();
      this.humidity = data.getHumidity();
      display(subject);
    } else {
      float price = (float) arg;
      this.price = price;
      display(subject);
    }
  }

  @Override
  public void display(Subject2 subject) {
    System.out.println("Current conditions: " + temperature + "F degrees and " + humidity
        + "% humidity and stock price is: " + price);
  }
}
