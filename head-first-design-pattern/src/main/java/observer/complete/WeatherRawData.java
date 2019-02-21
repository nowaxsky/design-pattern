package observer.complete;

public class WeatherRawData {
  private float temp;
  private float humidity;
  private float pressure;

  public WeatherRawData() {
    super();
  }

  public WeatherRawData(float temp, float humidity, float pressure) {
    super();
    this.temp = temp;
    this.humidity = humidity;
    this.pressure = pressure;
  }

  public float getTemp() {
    return temp;
  }

  public void setTemp(float temp) {
    this.temp = temp;
  }

  public float getHumidity() {
    return humidity;
  }

  public void setHumidity(float humidity) {
    this.humidity = humidity;
  }

  public float getPressure() {
    return pressure;
  }

  public void setPressure(float pressure) {
    this.pressure = pressure;
  }
}
