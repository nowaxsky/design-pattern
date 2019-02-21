package observer.complete;

import java.util.ArrayList;
import java.util.List;

public class StockData implements Subject2 {

  private List<Observer2> observer;
  private float price;
  
  public StockData() {
    observer = new ArrayList<>();
  }
  
  @Override
  public void registerObserver(Observer2 o) {
    observer.add(o);
  }

  @Override
  public void removeObserver(Observer2 o) {
    int i = this.observer.indexOf(o);
    if (i >= 0)
      observer.remove(o);
  }

  @Override
  public void notifyObserver() {
    observer.stream().forEach(o -> {
      o.update(new StockData(), price);
    });
  }
  
  public void measurementsChanged() {
    notifyObserver();
  }
  
  public void setPrice(float price) {
    this.price = price;
    measurementsChanged();
  }

}
