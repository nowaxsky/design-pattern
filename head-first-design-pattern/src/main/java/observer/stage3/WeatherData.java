package observer.stage3;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

  private List<Observer> observer;
  private float temp;
  private float humidity;
  private float pressure;

  public WeatherData() {
    observer = new ArrayList<>();
  }

  @Override
  public void registerObserver(Observer o) {
    observer.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    // TODO
  }

  // 不管觀察者為何, 因其實踐了Observer介面, 有一個統一方法update可以讓主題呼叫
  @Override
  public void notifyObserver() {
    observer.stream().forEach(o -> {
      o.update(temp, humidity, pressure);
    });
  }

  // 當氣象站得到更新數據時就通知觀察者
  public void measurementsChanged() {
    notifyObserver();
  }

  public void setMeasurements(float temp, float humidity, float pressure) {
    this.temp = temp;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

}
