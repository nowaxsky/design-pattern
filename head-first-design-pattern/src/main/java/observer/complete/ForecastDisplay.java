package observer.complete;

public class ForecastDisplay implements Observer, DisplayElement {

  private Subject weatherData;
  private float currentPressure = 29.92f;
  private float lastPressure;

  public ForecastDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }
  
  public void addSubject() {
    weatherData.registerObserver(this);
  }
  
  public void removeSubject() {
    weatherData.removeObserver(this);
  }

  @Override
  public void update(float temp, float humidity, float pressure) {
    lastPressure = currentPressure;
    currentPressure = pressure;

    display();
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
