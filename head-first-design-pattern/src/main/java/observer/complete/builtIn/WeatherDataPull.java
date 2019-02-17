package observer.complete.builtIn;

import java.util.Observable;

public class WeatherDataPull extends Observable {

  private float temp;
  private float humidity;
  private float pressure;

  // 建構式不需要再建立一個資料結構來記錄所有的觀察者
  public WeatherDataPull() {
  }

  // 當氣象站得到更新數據時就通知觀察者
  public void measurementsChanged() {
    setChanged();
    notifyObservers();
  }

  public void setMeasurements(float temp, float humidity, float pressure) {
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
  
}
