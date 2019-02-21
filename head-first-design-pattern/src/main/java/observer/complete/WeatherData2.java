package observer.complete;

import java.util.ArrayList;
import java.util.List;

public class WeatherData2 implements Subject2 {

  private List<Observer2> observer;
  private float temp;
  private float humidity;
  private float pressure;

  public WeatherData2() {
    observer = new ArrayList<>();
  }

  @Override
  public void registerObserver(Observer2 o) {
    observer.add(o);
  }

  @Override
  public void removeObserver(Observer2 o) {

    // 若不存在該觀察者則會回傳-1
    int i = this.observer.indexOf(o);
    if (i >= 0)
      observer.remove(o);
  }

  // 不管觀察者為何, 因其實踐了Observer介面, 有一個統一方法update可以讓主題呼叫
  @Override
  public void notifyObserver() {
    Object arg = new WeatherRawData(temp, humidity, pressure);
    observer.stream().forEach(o -> {
      o.update(new WeatherData2(), arg);
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
