# Observer Pattern 觀察者模式 - 2

## 問題

1. 觀察者模式對應到氣象監測系統中的各個角色為何?

Observer Pattern|Weather Station
--|--
Observer|Display
ConcreteObserver|CurrentConditionsDisplay, StatisticsDisplay, ForecastDisplay
Subject|Subject
ConcreteSubject|WeatherData
update()|update()

2. 請使用觀察者模式來重新設計氣象監測系統.
	* 請參考stage3.