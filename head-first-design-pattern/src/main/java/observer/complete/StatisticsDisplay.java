package observer.complete;

import java.util.ArrayList;
import java.util.List;

public class StatisticsDisplay implements Observer2, DisplayElement2 {

  private List<Subject2> subjects;
  private float maxTemp = 0.0f;
  private float minTemp = 200;
  private float tempSum = 0.0f;
  private int tempNumReadings;

  private float maxPrice;
  private float minPrice = 150;
  private float priceSum;
  private int priceNumReadings;

  public StatisticsDisplay(Subject2 weatherData, Subject2 stockData) {
    subjects = new ArrayList<>();
    subjects.add(weatherData);
    subjects.add(stockData);
    weatherData.registerObserver(this);
    stockData.registerObserver(this);
  }

  @Override
  public void update(Subject2 subject, Object arg) {
    if (subject instanceof WeatherData2) {
      WeatherRawData data = (WeatherRawData) arg;
      float temp = data.getTemp();
      tempSum += temp;
      tempNumReadings++;

      if (temp > maxTemp)
        maxTemp = temp;
      if (temp < minTemp)
        minTemp = temp;

      display(subject);
    } else {
      float price = (float) arg;
      priceSum += price;
      priceNumReadings++;

      if (price > maxPrice)
        maxPrice = price;
      if (price < minPrice)
        minPrice = price;

      display(subject);
    }
  }

  @Override
  public void display(Subject2 subject) {
    if (subject instanceof WeatherData2) {
      System.out.println("Avg/Max/Min temperature = " + (tempSum / tempNumReadings) + "/" + maxTemp
          + "/" + minTemp);
    } else {
      System.out.println(
          "Avg/Max/Min price = " + (priceSum / priceNumReadings) + "/" + maxPrice + "/" + minPrice);
    }


  }
}
