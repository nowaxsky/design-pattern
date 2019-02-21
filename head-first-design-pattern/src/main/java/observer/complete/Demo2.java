package observer.complete;

public class Demo2 {

  public static void main(String[] args) {
    WeatherData2 weatherData = new WeatherData2();
    StockData stockData = new StockData();

    CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData, stockData);
    MyDisplay myDisplay = new MyDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.2f);

    System.out.println("\n---current conditions display remove Weather subject---\n");
    currentConditionsDisplay.removeSubject(weatherData);
    weatherData.setMeasurements(83, 55, 28.2f);

    System.out.println("\n---current conditions display add Weather subject---\n");
    currentConditionsDisplay.addSubject(weatherData);
    weatherData.setMeasurements(87, 35, 30.0f);

    System.out.println("\n---Stock market is starting---\n");

    stockData.setPrice(150);
    stockData.setPrice(162);
    stockData.setPrice(179);
    stockData.setPrice(168);
    stockData.setPrice(133);

    System.out.println("\n---current conditions display register stock subject---\n");
    currentConditionsDisplay.addSubject(stockData);

    stockData.setPrice(122);
    stockData.setPrice(151);
    stockData.setPrice(168);
    stockData.setPrice(197);
    stockData.setPrice(211);
    
    System.out.println("\n---Mixing information---\n");
    
    stockData.setPrice(197);
    stockData.setPrice(220);
    weatherData.setMeasurements(87, 35, 30.4f);
    stockData.setPrice(202);
    weatherData.setMeasurements(89, 40, 29.8f);
    weatherData.setMeasurements(82, 45, 30.2f);
    stockData.setPrice(258);
    stockData.setPrice(245);
  }

}
