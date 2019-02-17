package observer.stage1;

public class WeatherData {

  private float temp;
  private float humidity;
  private float pressure;
  
  private CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
  private StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
  private ForecastDisplay forecastDisplay = new ForecastDisplay();
  
  void setMeasurements(float temp, float humidity, float pressure) {
    this.temp = temp;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  public float getTemp() {
    return temp;
  }

  public float getHumidity() {
    return humidity;
  }

  public float getPressure() {
    return pressure;
  }

  public void measurementsChanged() {
    float temp = getTemp();
    float humidity = getHumidity();
    float pressure = getPressure();
    
    currentConditionsDisplay.update(temp, humidity, pressure);
    statisticsDisplay.update(temp, humidity, pressure);
    forecastDisplay.update(temp, humidity, pressure);
  }
  
}
