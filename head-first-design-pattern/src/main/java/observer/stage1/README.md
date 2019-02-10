# 觀察者模式-1

## 氣象監測系統
* 氣象站有3個感測器, 分別監測溫度, 濕度和氣壓.
* WeatherData物件可以從氣象站使用getter方法取得資料.
* 取得新資料時, 要更新3個顯示布告板, 分別為CurrentConditionsDisplay, StatisticsDisplay, ForecastDisplay.

## 問題
* 增加或刪減布告板必須修改WeatherData程式, 如何優化? 使用觀察者模式!