package observer.complete.builtIn;

import java.util.Observable;

public class WeatherDataPush extends Observable {

  private float temp;
  private float humidity;
  private float pressure;
  private Data tempAndHumidity;

  // 建構式不需要再建立一個資料結構來記錄所有的觀察者
  public WeatherDataPush() {
  }

  // 當氣象站得到更新數據時就通知觀察者
  public void measurementsChanged() {
    tempAndHumidity = new Data(temp, humidity, pressure);
    setChanged();
    notifyObservers(tempAndHumidity);
  }

  public void setMeasurements(float temp, float humidity, float pressure) {
    this.temp = temp;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }
  
}
